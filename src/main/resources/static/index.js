function registerVehicle() {
    const bil = {
        pnummer : $("#pnummer").val(),
        navn : $("#navn").val(),
        adresse : $("#adresse").val(),
        kjennetegn : $("#kjennetegn").val(),
        bilmerke : $("#bilmerke").val(),
        biltype : $("#biltype").val()
    };

    console.log(bil)

    $.post("/registrer", bil);
}

function getBiler() {
    let html = "<tr>\n" +
        "        <th>Personnummer</th>\n" +
        "        <th>Navn</th>\n" +
        "        <th>Adresse</th>\n" +
        "        <th>Kjennetegn</th>\n" +
        "        <th>Bilmerke</th>\n" +
        "        <th>Biltype</th>\n" +
        "    </tr>";
    $.get("/hent", function (data) {
        for (let i = 0; i < data.length; i++) {
            console.log(data[i]);
            html += "<tr><td>" + data[i].pnummer +"</td>"
            html += "<td>" + data[i].navn + "</td>";
            html += "<td>" +data[i].adresse+"</td>";
            html += "<td>" + data[i].kjennetegn + "</td>";
            html += "<td>"+data[i].bilmerke + "</td>";
            html += "<td>"+data[i].biltype + "</td></tr>";

            $("#outputTable").html(html);
        }
    })
}