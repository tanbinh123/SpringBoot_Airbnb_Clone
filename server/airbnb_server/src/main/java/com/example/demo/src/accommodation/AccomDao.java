package com.example.demo.src.accommodation;


import com.example.demo.src.accommodation.model.GetAccomImgUrlRes;
import com.example.demo.src.accommodation.model.GetAccomRes;
import com.example.demo.src.member.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class AccomDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<GetAccomRes> selectAccoms() {
        String selectAccomsQuery = "select accom_id,\n" +
                "       accom_name,\n" +
                "       accom_address,\n" +
                "       price\n" +
                "from Accommodation\n" +
                "where status = 'active';";

        String selectAccomImgsQuery = "select accomImg_id,\n" +
                "       accomImg_url\n" +
                "from AccomImg\n" +
                "where status = 'active' and\n" +
                "      accom_id = ?;";

        return this.jdbcTemplate.query(selectAccomsQuery,
                (rs, rowNum) -> new GetAccomRes(
                        rs.getInt("accom_id"),
                        rs.getString("accom_name"),
                        rs.getString("accom_address"),
                        rs.getInt("price"),
                        jdbcTemplate.query(selectAccomImgsQuery,
                                (rk, rowNum_k) -> new GetAccomImgUrlRes(
                                        rk.getInt("accomImg_id"),
                                        rk.getString("accomImg_url")
                                ), rs.getInt("accom_id"))
                ));
    }
}



