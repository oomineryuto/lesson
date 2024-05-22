package com.example.lesson.repository;

import com.example.lesson.Entity.InsertProduct;
import com.example.lesson.Entity.ProductsRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductsRepository implements IProductsRepository{
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<ProductsRecord> findAll() {
        return jdbcTemplate.query("SELECT * FROM products ORDER BY id",
                new DataClassRowMapper<ProductsRecord>(ProductsRecord.class));
    }
    @Override
    public ProductsRecord findById(int id) {
        var param = new MapSqlParameterSource();
        param.addValue("id", id);
        var list = jdbcTemplate.query("SELECT * FROM products WHERE id = :id", param, new DataClassRowMapper<>(ProductsRecord.class));
        return list.isEmpty() ? null : list.get(0);
    }
    @Override
    public int insert(InsertProduct insertProduct) {
        var param = new MapSqlParameterSource();
        param.addValue("name", insertProduct.name());
        param.addValue("price", insertProduct.price());
        return jdbcTemplate.update("INSERT INTO products(name,price) VALUES(:name, :price)", param);
    }
    @Override
    public int update(ProductsRecord productsRecord){
        var param = new MapSqlParameterSource();
        param.addValue("id",productsRecord.id());
        param.addValue("name",productsRecord.name());
        param.addValue("price",productsRecord.price());
        return jdbcTemplate.update("UPDATE products SET name = :name, price = :price WHERE id = :id", param);
    }
    @Override
    public int delete(int id){
        var param = new MapSqlParameterSource();
        param.addValue("id",id);
        return jdbcTemplate.update("DELETE FROM products Where id = :id",param);

    }

}
