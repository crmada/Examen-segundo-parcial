package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.examen.jimmy.yepez.entity.Car;
public class Interface {

public interface CarRepository extends JpaRepository<CarRepository,Integer> {
}