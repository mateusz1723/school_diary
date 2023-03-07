package pl.kurs.schooldiary2.service;

import org.springframework.dao.EmptyResultDataAccessException;
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
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("THere is no entity with id");
        }
    }

    @Override
    public T edit(T entity) {
        return repository.save(
                Optional.ofNullable(entity)
                .filter(x -> Objects.nonNull(x.getId()))
                .orElseThrow(() -> new RuntimeException("Bad entity"))
        );
    }

    @Override
    public T get(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("There is no entity with id: " + id));
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }
}
