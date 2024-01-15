package io.github.adnan0231.motorvognregister;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class motorvognHandler {

    private HashMap<String, Motorvogn> motorvognHashMap = new HashMap<>();

    @PostMapping("/registrer")
    public void registrer(String pnummer, String navn, String adresse, String kjennetegn, String bilmerke, String biltype) {
        Motorvogn motorvogn = new Motorvogn(pnummer, navn, adresse, kjennetegn, bilmerke, biltype);

        motorvognHashMap.put(kjennetegn, motorvogn);
    }

    @GetMapping("/hent")
    public ArrayList<Motorvogn> hent() {
        return new ArrayList<>(motorvognHashMap.values());
    }
}
