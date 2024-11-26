package pe.edu.i202225123.cl1_jpa_data_Damart_Diana;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202225123.cl1_jpa_data_Damart_Diana.model.Country;
import pe.edu.i202225123.cl1_jpa_data_Damart_Diana.repository.CountryRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Cl1JpaDataDamartDianaApplication implements CommandLineRunner {

	@Autowired
	CountryRepository countryRepository;
	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataDamartDianaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Optional<Country> argentina = countryRepository.findById("ARG");
		argentina.ifPresentOrElse(
				Country -> {
					System.out.println("--------------------: Lenguajes de Argentina: ----------");
					Country.getLanguages().forEach(language -> System.out.println(language.getLanguage()));
					System.out.println("--------------------------------------------------");
				},() -> {
					Optional<Country> perCountry = countryRepository.findById("PER");
					perCountry.ifPresent(per -> {
						System.out.println("----------------:lengua de Perú :------------------");
						per.getLanguages().forEach(lang -> System.out.println(lang.getLanguage()));
						System.out.println("--------------------------------------------------");
					});
				}
		);

		// Lista de IDs de los países a eliminar
		/*List<String> countryIdsToDelete = Arrays.asList("COL", "ARG");

		countryRepository.deleteAllById(countryIdsToDelete);
		System.out.println("Países eliminados con sus ciudades y lenguajes asociados");*/

	}
}
