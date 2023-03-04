package pl.kurs.schooldiary2.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class GenericManagementService<T, R extends JpaRepository<T, Long>> implements IManagementService<T>{

    private R repository;

    public GenericManagementService(R repository) {
        this.repository = repository;
    }

    @Override
    public T add(T entity) {
        repository.save(entity);
        return null;//todo zakonczenie
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public T edit(T entity) {
        return null;
    }

    @Override
    public T get(Long id) {
        return null;
    }

    @Override
    public List<T> getAll() {
        return null;
    }
}
