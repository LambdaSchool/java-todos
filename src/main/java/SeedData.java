import models.Role;
import models.Todo;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import service.RoleService;
import service.UserService;

import javax.transaction.Transactional;
import java.util.Date;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;


    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");
        Role r3 = new Role("data");

        r1 = roleService.save(r1);
        r2 = roleService.save(r2);
        r3 = roleService.save(r3);

        User u1 = new User("admin",
                "password",
                "admin@lambdaschool.local");
        u1.addRoles(r1);
        u1.addRoles(r2);
        u1.addRoles(r3);
        u1.getTodos()
                .add(new Todo("Finish java-orders-swagger",
                        new Date().getTime(),
                        u1));
        u1.getTodos()
                .add(new Todo("Feed the turtles",
                        new Date().getTime(),
                        u1));
        u1.getTodos()
                .add(new Todo("Complete the sprint challenge",
                        new Date().getTime(),
                        u1));

        userService.save(u1);

        User u2 = new User("cinnamon",
                "1234567",
                "cinnamon@lambdaschool.local");
        u2.addRoles(r2);
        u2.addRoles(r3);
        u2.getTodos()
                .add(new Todo("Walk the dogs",
                        new Date().getTime(),
                        u2));
        u2.getTodos()
                .add(new Todo("provide feedback to my instructor",
                        new Date().getTime(),
                        u2));
        userService.save(u2);

        // user
        User u3 = new User("barnbarn",
                "ILuvM4th!",
                "barnbarn@lambdaschool.local");
        u3.addRoles(r2);
        userService.save(u3);


        User u4 = new User("puttat",
                "password",
                "puttat@school.lambda");
        u4.addRoles(r2);
        userService.save(u4);

        User u5 = new User("misskitty",
                "password",
                "misskitty@school.lambda");
        userService.save(u5);
    }
}