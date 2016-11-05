package converter;

import converter.dao.CurrencyService;
import converter.entities.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.stereotype.Controller("/")
public class Controller {
    @Autowired
    CurrencyService currencyService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getHaha() {
        Currency currency1 = new Currency("RUB", "Ruble", 0.015625, "Russia");
        Currency currency2 = new Currency("USD", "Dollar", 1, "USA");
        Currency currency3 = new Currency("EUR", "Euro", 1.109375, "Europe");
        currencyService.saveCurrency(currency1);
        currencyService.saveCurrency(currency2);
        currencyService.saveCurrency(currency3);
        return new ModelAndView("home");
    }

    @RequestMapping(value = "course", method = RequestMethod.GET)
    @ResponseBody
    public Double getCourse(String inputCurrency, String outputCurrency) {
        Currency input = null;
        Currency output = null;
        List<Currency> currencyList = currencyService.getAllCurrencies();
        for (Currency currency : currencyList) {
            if (currency.getLabel().equals(inputCurrency))
                input = currency;
            if (currency.getLabel().equals(outputCurrency))
                output = currency;

        }
        if (input != null && output != null)
            return (input.getValue()) / (output.getValue());
        return 1.0;
    }

    @RequestMapping(value = "currency", method = RequestMethod.GET)
    @ResponseBody
    public List<Currency> getCurrencies() {
        List<Currency> currencyList = currencyService.getAllCurrencies();
        return currencyList;
    }

}
