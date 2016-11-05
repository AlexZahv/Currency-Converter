package converter.dao;

import converter.entities.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;

    public void saveCurrency(Currency currency) {
        currencyRepository.save(currency);
    }

    public Currency getCurrency(String label) {
        return currencyRepository.findByLabel(label);
    }

    public List<Currency> getAllCurrencies() {
        Iterable<Currency> currencies = currencyRepository.findAll();
        List<Currency> currencyList=new ArrayList<Currency>();
        for (Currency currency:currencies){
            currencyList.add(currency);
        }
        return currencyList;
    }
}
