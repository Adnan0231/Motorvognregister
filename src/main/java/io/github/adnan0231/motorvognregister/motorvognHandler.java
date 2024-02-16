package io.github.adnan0231.motorvognregister;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class motorvognHandler {

    private List<Motorvogn> motorvognList = new ArrayList<>();

    @PostMapping("/registrer")
    public void registrer(String pnummer, String navn, String adresse, String kjennetegn, String bilmerke, String biltype) {
        Motorvogn motorvogn = new Motorvogn(pnummer, navn, adresse, kjennetegn, bilmerke, biltype);
        motorvognList.add(motorvogn);
    }

    @GetMapping("/hent")
    public List<Motorvogn> hent() {
        return new ArrayList<>(motorvognList);
    }
}
