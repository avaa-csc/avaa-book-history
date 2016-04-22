package fi.csc.avaa.khl.db.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link fi.csc.avaa.khl.db.service.http.VanhatkirjatServiceSoap}.
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.http.VanhatkirjatServiceSoap
 * @generated
 */
public class VanhatkirjatSoap implements Serializable {
    private int _vkid;
    private int _kuntaid;
    private int _maakuntaid;
    private int _lomakenum;
    private Date _paivays;
    private int _kartkohde;
    private String _tekija;
    private String _teoknimi;
    private int _painovuosi;
    private String _painopaikka;
    private String _kirjapaino;
    private int _painosmerk;
    private int _imprimatur;
    private int _kuvitus;
    private int _kartat;
    private int _liitteita;
    private String _nimikirj;
    private int _sinetti;
    private int _leima;
    private int _exlibris;
    private int _hintamerk;
    private String _omiste;
    private String _reunamerk;
    private String _lisatieto;
    private String _lahosoite;
    private String _lahemail;
    private int _status;
    private int _kieliid;
    private int _kielestaid;
    private int _julklajiid;
    private int _kuntoid;
    private int _puuteid;
    private int _teospkid;
    private int _sidonta;
    private String _kokoelma;
    private Date _poistettu;
    private Date _muokattu;

    public VanhatkirjatSoap() {
    }

    public static VanhatkirjatSoap toSoapModel(Vanhatkirjat model) {
        VanhatkirjatSoap soapModel = new VanhatkirjatSoap();

        soapModel.setVkid(model.getVkid());
        soapModel.setKuntaid(model.getKuntaid());
        soapModel.setMaakuntaid(model.getMaakuntaid());
        soapModel.setLomakenum(model.getLomakenum());
        soapModel.setPaivays(model.getPaivays());
        soapModel.setKartkohde(model.getKartkohde());
        soapModel.setTekija(model.getTekija());
        soapModel.setTeoknimi(model.getTeoknimi());
        soapModel.setPainovuosi(model.getPainovuosi());
        soapModel.setPainopaikka(model.getPainopaikka());
        soapModel.setKirjapaino(model.getKirjapaino());
        soapModel.setPainosmerk(model.getPainosmerk());
        soapModel.setImprimatur(model.getImprimatur());
        soapModel.setKuvitus(model.getKuvitus());
        soapModel.setKartat(model.getKartat());
        soapModel.setLiitteita(model.getLiitteita());
        soapModel.setNimikirj(model.getNimikirj());
        soapModel.setSinetti(model.getSinetti());
        soapModel.setLeima(model.getLeima());
        soapModel.setExlibris(model.getExlibris());
        soapModel.setHintamerk(model.getHintamerk());
        soapModel.setOmiste(model.getOmiste());
        soapModel.setReunamerk(model.getReunamerk());
        soapModel.setLisatieto(model.getLisatieto());
        soapModel.setLahosoite(model.getLahosoite());
        soapModel.setLahemail(model.getLahemail());
        soapModel.setStatus(model.getStatus());
        soapModel.setKieliid(model.getKieliid());
        soapModel.setKielestaid(model.getKielestaid());
        soapModel.setJulklajiid(model.getJulklajiid());
        soapModel.setKuntoid(model.getKuntoid());
        soapModel.setPuuteid(model.getPuuteid());
        soapModel.setTeospkid(model.getTeospkid());
        soapModel.setSidonta(model.getSidonta());
        soapModel.setKokoelma(model.getKokoelma());
        soapModel.setPoistettu(model.getPoistettu());
        soapModel.setMuokattu(model.getMuokattu());

        return soapModel;
    }

    public static VanhatkirjatSoap[] toSoapModels(Vanhatkirjat[] models) {
        VanhatkirjatSoap[] soapModels = new VanhatkirjatSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static VanhatkirjatSoap[][] toSoapModels(Vanhatkirjat[][] models) {
        VanhatkirjatSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new VanhatkirjatSoap[models.length][models[0].length];
        } else {
            soapModels = new VanhatkirjatSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static VanhatkirjatSoap[] toSoapModels(List<Vanhatkirjat> models) {
        List<VanhatkirjatSoap> soapModels = new ArrayList<VanhatkirjatSoap>(models.size());

        for (Vanhatkirjat model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new VanhatkirjatSoap[soapModels.size()]);
    }

    public int getPrimaryKey() {
        return _vkid;
    }

    public void setPrimaryKey(int pk) {
        setVkid(pk);
    }

    public int getVkid() {
        return _vkid;
    }

    public void setVkid(int vkid) {
        _vkid = vkid;
    }

    public int getKuntaid() {
        return _kuntaid;
    }

    public void setKuntaid(int kuntaid) {
        _kuntaid = kuntaid;
    }

    public int getMaakuntaid() {
        return _maakuntaid;
    }

    public void setMaakuntaid(int maakuntaid) {
        _maakuntaid = maakuntaid;
    }

    public int getLomakenum() {
        return _lomakenum;
    }

    public void setLomakenum(int lomakenum) {
        _lomakenum = lomakenum;
    }

    public Date getPaivays() {
        return _paivays;
    }

    public void setPaivays(Date paivays) {
        _paivays = paivays;
    }

    public int getKartkohde() {
        return _kartkohde;
    }

    public void setKartkohde(int kartkohde) {
        _kartkohde = kartkohde;
    }

    public String getTekija() {
        return _tekija;
    }

    public void setTekija(String tekija) {
        _tekija = tekija;
    }

    public String getTeoknimi() {
        return _teoknimi;
    }

    public void setTeoknimi(String teoknimi) {
        _teoknimi = teoknimi;
    }

    public int getPainovuosi() {
        return _painovuosi;
    }

    public void setPainovuosi(int painovuosi) {
        _painovuosi = painovuosi;
    }

    public String getPainopaikka() {
        return _painopaikka;
    }

    public void setPainopaikka(String painopaikka) {
        _painopaikka = painopaikka;
    }

    public String getKirjapaino() {
        return _kirjapaino;
    }

    public void setKirjapaino(String kirjapaino) {
        _kirjapaino = kirjapaino;
    }

    public int getPainosmerk() {
        return _painosmerk;
    }

    public void setPainosmerk(int painosmerk) {
        _painosmerk = painosmerk;
    }

    public int getImprimatur() {
        return _imprimatur;
    }

    public void setImprimatur(int imprimatur) {
        _imprimatur = imprimatur;
    }

    public int getKuvitus() {
        return _kuvitus;
    }

    public void setKuvitus(int kuvitus) {
        _kuvitus = kuvitus;
    }

    public int getKartat() {
        return _kartat;
    }

    public void setKartat(int kartat) {
        _kartat = kartat;
    }

    public int getLiitteita() {
        return _liitteita;
    }

    public void setLiitteita(int liitteita) {
        _liitteita = liitteita;
    }

    public String getNimikirj() {
        return _nimikirj;
    }

    public void setNimikirj(String nimikirj) {
        _nimikirj = nimikirj;
    }

    public int getSinetti() {
        return _sinetti;
    }

    public void setSinetti(int sinetti) {
        _sinetti = sinetti;
    }

    public int getLeima() {
        return _leima;
    }

    public void setLeima(int leima) {
        _leima = leima;
    }

    public int getExlibris() {
        return _exlibris;
    }

    public void setExlibris(int exlibris) {
        _exlibris = exlibris;
    }

    public int getHintamerk() {
        return _hintamerk;
    }

    public void setHintamerk(int hintamerk) {
        _hintamerk = hintamerk;
    }

    public String getOmiste() {
        return _omiste;
    }

    public void setOmiste(String omiste) {
        _omiste = omiste;
    }

    public String getReunamerk() {
        return _reunamerk;
    }

    public void setReunamerk(String reunamerk) {
        _reunamerk = reunamerk;
    }

    public String getLisatieto() {
        return _lisatieto;
    }

    public void setLisatieto(String lisatieto) {
        _lisatieto = lisatieto;
    }

    public String getLahosoite() {
        return _lahosoite;
    }

    public void setLahosoite(String lahosoite) {
        _lahosoite = lahosoite;
    }

    public String getLahemail() {
        return _lahemail;
    }

    public void setLahemail(String lahemail) {
        _lahemail = lahemail;
    }

    public int getStatus() {
        return _status;
    }

    public void setStatus(int status) {
        _status = status;
    }

    public int getKieliid() {
        return _kieliid;
    }

    public void setKieliid(int kieliid) {
        _kieliid = kieliid;
    }

    public int getKielestaid() {
        return _kielestaid;
    }

    public void setKielestaid(int kielestaid) {
        _kielestaid = kielestaid;
    }

    public int getJulklajiid() {
        return _julklajiid;
    }

    public void setJulklajiid(int julklajiid) {
        _julklajiid = julklajiid;
    }

    public int getKuntoid() {
        return _kuntoid;
    }

    public void setKuntoid(int kuntoid) {
        _kuntoid = kuntoid;
    }

    public int getPuuteid() {
        return _puuteid;
    }

    public void setPuuteid(int puuteid) {
        _puuteid = puuteid;
    }

    public int getTeospkid() {
        return _teospkid;
    }

    public void setTeospkid(int teospkid) {
        _teospkid = teospkid;
    }

    public int getSidonta() {
        return _sidonta;
    }

    public void setSidonta(int sidonta) {
        _sidonta = sidonta;
    }

    public String getKokoelma() {
        return _kokoelma;
    }

    public void setKokoelma(String kokoelma) {
        _kokoelma = kokoelma;
    }

    public Date getPoistettu() {
        return _poistettu;
    }

    public void setPoistettu(Date poistettu) {
        _poistettu = poistettu;
    }

    public Date getMuokattu() {
        return _muokattu;
    }

    public void setMuokattu(Date muokattu) {
        _muokattu = muokattu;
    }
}
