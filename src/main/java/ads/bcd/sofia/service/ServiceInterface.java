package ads.bcd.sofia.service;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface<T> {

    List<T> findAll();

    Optional<T> findById(Integer id);

    T save(T object);

    void deleteById(Integer id);

    boolean existsById(Integer id);

}
