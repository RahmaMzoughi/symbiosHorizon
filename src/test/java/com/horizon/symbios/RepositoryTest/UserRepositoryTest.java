package com.horizon.symbios.RepositoryTest;

import com.horizon.symbios.models.User;
import com.horizon.symbios.repository.IUserRepository;

import com.horizon.symbios.services.CreateUserService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTest {

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private CreateUserService createUserService;

        @Test
        public void testSaveNewUser() {
            User user = new User("Rahma", "test@gmail.com", "11111");

            when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);

            User created = createUserService.createNewUser(user);

            assertThat(created.getName()).isSameAs(user.getName());
            verify(userRepository).save(user);

            assertThat(user.getUsername()).isEqualTo("Rahma");
        }
    }
}
