"use strict";
console.log("testi"); //console login testiteksti

const teksti = document.getElementById('a1'); //tehdään väriä muuttavalle tekstille olio ..
console.log(teksti); //.. ja tarkastellaan consolessa

teksti.style.color = 'black'; //tekstin väri on aina musta alussa riippumatta ulkoisista tekijöistä

const vartalo = document.getElementById('vartalo'); //tehdään bodylle oma js-tunniste

//tehdään Jyväskylälle olio ..
const Jyvaskyla = {
    nimi: 'Jyväskylä',
    väkiluku: '144299',
    väestotiheys: '123,23/km2',
    kunnallisvero: '20%'
}
console.log(Jyvaskyla); //.. ja tarkastellaan consolessa

//muuttaa tekstin punaiseksi
function tekstiPunaiseksi() {
    teksti.style.color = 'red';
}

//muuttaa tekstin siniseksi
function tekstiSiniseksi() {
    teksti.style.color = 'blue';
}

//lisää tekstielementin kenttään kirjoitetun perusteella
function lisaaElementti() {
    let uusi = document.createElement("p");
    const sisalto = document.getElementById('tekstikentta');
    uusi.textContent = sisalto.value;
    vartalo.appendChild(uusi);
}