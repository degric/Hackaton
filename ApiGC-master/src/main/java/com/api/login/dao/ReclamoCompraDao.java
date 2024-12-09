package com.api.login.dao;

import com.api.login.pojo.ReclamoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamoCompraDao extends JpaRepository<ReclamoCompra, Integer> {


}
