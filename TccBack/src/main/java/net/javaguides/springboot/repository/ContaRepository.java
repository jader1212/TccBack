package net.javaguides.springboot.repository;

import java.util.ArrayList;
//import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

    List<Conta> findByTipo(Long tipo);  

    @Query(value = "SELECT sum(valor) FROM Conta where tipo = 1")
    public String sumReceita();

    @Query(value = "SELECT sum(valor) FROM Conta where tipo = 0")
    public String sumDespesa();    

    @Query(value = "SELECT DATE_FORMAT(data, '%M %Y') as name, CASE WHEN tipo = 1 THEN valor END as receita, CASE WHEN tipo = 0 THEN valor END as despesa FROM Conta")
    ArrayList<Object[]> getRelContas(); 
}
