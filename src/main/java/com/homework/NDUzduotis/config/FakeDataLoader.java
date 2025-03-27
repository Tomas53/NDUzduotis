package com.homework.NDUzduotis.config;

import com.homework.NDUzduotis.model.Role;
import com.homework.NDUzduotis.model.User;
import com.homework.NDUzduotis.model.Status;
import com.homework.NDUzduotis.model.Task;
import com.homework.NDUzduotis.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class FakeDataLoader implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        User tomas = new User(null, "tomas", passwordEncoder.encode("tomas"), Role.USER, null);
        Task tomasTask1 = new Task(null, "Do groceries", Status.PENDING, "Buy milk", tomas);
        Task tomasTask2 = new Task(null, "Tidy room", Status.PENDING, "Do the vacuuming and tidy your bed", tomas);

        tomas.setTasks(Arrays.asList(tomasTask1, tomasTask2));

        userRepository.save(tomas);

        User jonas = new User(null, "jonas", passwordEncoder.encode("jonas"), Role.USER, null);
        Task jonasTask1 = new Task(null, "Do sports", Status.PENDING, "play basketball", jonas);
        Task jonasTask2 = new Task(null, "Fix car", Status.PENDING, "Change oil", jonas);

        jonas.setTasks(Arrays.asList(jonasTask1, jonasTask2));

        userRepository.save(jonas);
        System.out.println("Command runner works");
    }
}
