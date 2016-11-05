package converter.dao;

import converter.entities.Currency;
import org.springframework.data.repository.CrudRepository;

interface CurrencyRepository extends CrudRepository<Currency, String> {
    Currency findByLabel(String label);
}
