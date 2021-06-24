package Controller;

import com.cristhian.barros.Examen.entities.Productos;
import com.cristhian.barros.Examen.entities.Productos;
import com.cristhian.barros.Examen.repositories.ProductosRepository;
import com.cristhian.barros.Examen.repositories.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class CarController {

    private CarRepository carRepository;

    @Autowired
    public CarController(carRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAllCar() {
        return this.carRepository.findAll();
    }

    public Optional<Car> findCarById(int id){
        return this.carRepository.findById(id);
    }


    public void createCar(Car car){
        this.carRepository.save(car);
    }

    public boolean editCarById(int id, Car car){
        Optional<Car> carOptional = this.findCarById(id);
        if( !carOptional.isPresent()) return false;
        Car cardb = carOptional.get();
        cardb.setBrand(car.getBrand());
        cardb.setModel(car.getModel());
        cardb.setPrice(car.getPrice());
        carRepository.save(cardb);
        return true;
    }

    public boolean deleteCarById(int id) {
        Optional<Car> carOptional = this.findCarById(id);
        if (!carOptional.isPresent()) return false;
        carRepository.deleteById(id);
        return true;
    }

}