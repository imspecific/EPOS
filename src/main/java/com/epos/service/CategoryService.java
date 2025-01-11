package com.epos.service;

import com.epos.model.Category;
import com.epos.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryService implements CategoryRepo {

    @Autowired
    private JdbcTemplate jdbctemplate;

    @Override
    public int save(Category category) {
        return jdbctemplate.update("INSERT INTO epos_category (prod_category, prod_brand) VALUES (?, ?)",
                new Object[]{category.getProdCategory(), category.getProdBrand()});

    }

    @Override
    public List<Category> findAllCategory() {
        return jdbctemplate.query("SELECT * from epos_category", new ResultSetExtractor<List<Category>>() {

            @Override
            public List<Category> extractData(ResultSet rs) throws SQLException, DataAccessException {

                List<Category> categoryList = new ArrayList<>();
                while (rs.next()) {
                    Category category = new Category();
                    category.setProdCategory(rs.getString(1));
                    category.setProdBrand((rs.getString(2)));
                    categoryList.add(category);
                }
                return categoryList;
            }
        });
    }

}
