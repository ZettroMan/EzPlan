package ru.gb.zettro.ezplan.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.zettro.ezplan.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
