package pl.mloza.database;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;
import pl.mloza.model.ValidEntity;
import pl.mloza.repositories.ValidEntityRepository;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ValidEntityTest {

    @Autowired
    private ValidEntityRepository validEntityRepository;

    @Test
    public void shouldThrowErrorOnInvalidEntity() {
        ValidEntity invalidEntity = new ValidEntity(10, "O", "123-123");

        assertThrows(
                TransactionSystemException.class,
                () -> validEntityRepository.save(invalidEntity));
    }
}
