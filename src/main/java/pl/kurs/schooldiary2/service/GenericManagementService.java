package pl.kurs.schooldiary2.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.schooldiary2.model.Identificationable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class GenericManagementService<T extends Identificationable, R extends JpaRepository<T, Long>> implements IManagementService<T>{

    private R repository;

    public GenericManagementService(R repository) {
        this.repository = repository;
    }

    @Override
    public T add(T entity) {
        return repository.save(
                Optional.ofNullable(entity)
                .filter(x -> Objects.isNull(x.getId()))
                .orElseThrow(() -> new RuntimeException("Bad entity!"))
        );
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
