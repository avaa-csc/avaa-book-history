package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Vanhatkirjat}.
 * </p>
 *
 * @author CSC
 * @see Vanhatkirjat
 * @generated
 */
public class VanhatkirjatWrapper implements Vanhatkirjat,
    ModelWrapper<Vanhatkirjat> {
    private Vanhatkirjat _vanhatkirjat;

    public VanhatkirjatWrapper(Vanhatkirjat vanhatkirjat) {
        _vanhatkirjat = vanhatkirjat;
    }

    @Override
    public Class<?> getModelClass() {
        return Vanhatkirjat.class;
    }

    @Override
    public String getModelClassName() {
        return Vanhatkirjat.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("vkid", getVkid());
        attributes.put("kuntaid", getKuntaid());
        attributes.put("maakuntaid", getMaakuntaid());
        attributes.put("lomakenum", getLomakenum());
        attributes.put("paivays", getPaivays());
        attributes.put("kartkohde", getKartkohde());
        attributes.put("tekija", getTekija());
        attributes.put("teoknimi", getTeoknimi());
        attributes.put("painovuosi", getPainovuosi());
        attributes.put("painopaikka", getPainopaikka());
        attributes.put("kirjapaino", getKirjapaino());
        attributes.put("painosmerk", getPainosmerk());
        attributes.put("imprimatur", getImprimatur());
        attributes.put("kuvitus", getKuvitus());
        attributes.put("kartat", getKartat());
        attributes.put("liitteita", getLiitteita());
        attributes.put("nimikirj", getNimikirj());
        attributes.put("sinetti", getSinetti());
        attributes.put("leima", getLeima());
        attributes.put("exlibris", getExlibris());
        attributes.put("hintamerk", getHintamerk());
        attributes.put("omiste", getOmiste());
        attributes.put("reunamerk", getReunamerk());
        attributes.put("lisatieto", getLisatieto());
        attributes.put("lahosoite", getLahosoite());
        attributes.put("lahemail", getLahemail());
        attributes.put("status", getStatus());
        attributes.put("kieliid", getKieliid());
        attributes.put("kielestaid", getKielestaid());
        attributes.put("julklajiid", getJulklajiid());
        attributes.put("kuntoid", getKuntoid());
        attributes.put("puuteid", getPuuteid());
        attributes.put("teospkid", getTeospkid());
        attributes.put("sidonta", getSidonta());
        attributes.put("kokoelma", getKokoelma());
        attributes.put("poistettu", getPoistettu());
        attributes.put("muokattu", getMuokattu());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Integer vkid = (Integer) attributes.get("vkid");

        if (vkid != null) {
            setVkid(vkid);
        }

        Integer kuntaid = (Integer) attributes.get("kuntaid");

        if (kuntaid != null) {
            setKuntaid(kuntaid);
        }

        Integer maakuntaid = (Integer) attributes.get("maakuntaid");

        if (maakuntaid != null) {
            setMaakuntaid(maakuntaid);
        }

        Integer lomakenum = (Integer) attributes.get("lomakenum");

        if (lomakenum != null) {
            setLomakenum(lomakenum);
        }

        Date paivays = (Date) attributes.get("paivays");

        if (paivays != null) {
            setPaivays(paivays);
        }

        Integer kartkohde = (Integer) attributes.get("kartkohde");

        if (kartkohde != null) {
            setKartkohde(kartkohde);
        }

        String tekija = (String) attributes.get("tekija");

        if (tekija != null) {
            setTekija(tekija);
        }

        String teoknimi = (String) attributes.get("teoknimi");

        if (teoknimi != null) {
            setTeoknimi(teoknimi);
        }

        Integer painovuosi = (Integer) attributes.get("painovuosi");

        if (painovuosi != null) {
            setPainovuosi(painovuosi);
        }

        String painopaikka = (String) attributes.get("painopaikka");

        if (painopaikka != null) {
            setPainopaikka(painopaikka);
        }

        String kirjapaino = (String) attributes.get("kirjapaino");

        if (kirjapaino != null) {
            setKirjapaino(kirjapaino);
        }

        Integer painosmerk = (Integer) attributes.get("painosmerk");

        if (painosmerk != null) {
            setPainosmerk(painosmerk);
        }

        Integer imprimatur = (Integer) attributes.get("imprimatur");

        if (imprimatur != null) {
            setImprimatur(imprimatur);
        }

        Integer kuvitus = (Integer) attributes.get("kuvitus");

        if (kuvitus != null) {
            setKuvitus(kuvitus);
        }

        Integer kartat = (Integer) attributes.get("kartat");

        if (kartat != null) {
            setKartat(kartat);
        }

        Integer liitteita = (Integer) attributes.get("liitteita");

        if (liitteita != null) {
            setLiitteita(liitteita);
        }

        String nimikirj = (String) attributes.get("nimikirj");

        if (nimikirj != null) {
            setNimikirj(nimikirj);
        }

        Integer sinetti = (Integer) attributes.get("sinetti");

        if (sinetti != null) {
            setSinetti(sinetti);
        }

        Integer leima = (Integer) attributes.get("leima");

        if (leima != null) {
            setLeima(leima);
        }

        Integer exlibris = (Integer) attributes.get("exlibris");

        if (exlibris != null) {
            setExlibris(exlibris);
        }

        Integer hintamerk = (Integer) attributes.get("hintamerk");

        if (hintamerk != null) {
            setHintamerk(hintamerk);
        }

        String omiste = (String) attributes.get("omiste");

        if (omiste != null) {
            setOmiste(omiste);
        }

        String reunamerk = (String) attributes.get("reunamerk");

        if (reunamerk != null) {
            setReunamerk(reunamerk);
        }

        String lisatieto = (String) attributes.get("lisatieto");

        if (lisatieto != null) {
            setLisatieto(lisatieto);
        }

        String lahosoite = (String) attributes.get("lahosoite");

        if (lahosoite != null) {
            setLahosoite(lahosoite);
        }

        String lahemail = (String) attributes.get("lahemail");

        if (lahemail != null) {
            setLahemail(lahemail);
        }

        Integer status = (Integer) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Integer kieliid = (Integer) attributes.get("kieliid");

        if (kieliid != null) {
            setKieliid(kieliid);
        }

        Integer kielestaid = (Integer) attributes.get("kielestaid");

        if (kielestaid != null) {
            setKielestaid(kielestaid);
        }

        Integer julklajiid = (Integer) attributes.get("julklajiid");

        if (julklajiid != null) {
            setJulklajiid(julklajiid);
        }

        Integer kuntoid = (Integer) attributes.get("kuntoid");

        if (kuntoid != null) {
            setKuntoid(kuntoid);
        }

        Integer puuteid = (Integer) attributes.get("puuteid");

        if (puuteid != null) {
            setPuuteid(puuteid);
        }

        Integer teospkid = (Integer) attributes.get("teospkid");

        if (teospkid != null) {
            setTeospkid(teospkid);
        }

        Integer sidonta = (Integer) attributes.get("sidonta");

        if (sidonta != null) {
            setSidonta(sidonta);
        }

        String kokoelma = (String) attributes.get("kokoelma");

        if (kokoelma != null) {
            setKokoelma(kokoelma);
        }

        Date poistettu = (Date) attributes.get("poistettu");

        if (poistettu != null) {
            setPoistettu(poistettu);
        }

        Date muokattu = (Date) attributes.get("muokattu");

        if (muokattu != null) {
            setMuokattu(muokattu);
        }
    }

    /**
    * Returns the primary key of this vanhatkirjat.
    *
    * @return the primary key of this vanhatkirjat
    */
    @Override
    public int getPrimaryKey() {
        return _vanhatkirjat.getPrimaryKey();
    }

    /**
    * Sets the primary key of this vanhatkirjat.
    *
    * @param primaryKey the primary key of this vanhatkirjat
    */
    @Override
    public void setPrimaryKey(int primaryKey) {
        _vanhatkirjat.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the vkid of this vanhatkirjat.
    *
    * @return the vkid of this vanhatkirjat
    */
    @Override
    public int getVkid() {
        return _vanhatkirjat.getVkid();
    }

    /**
    * Sets the vkid of this vanhatkirjat.
    *
    * @param vkid the vkid of this vanhatkirjat
    */
    @Override
    public void setVkid(int vkid) {
        _vanhatkirjat.setVkid(vkid);
    }

    /**
    * Returns the kuntaid of this vanhatkirjat.
    *
    * @return the kuntaid of this vanhatkirjat
    */
    @Override
    public int getKuntaid() {
        return _vanhatkirjat.getKuntaid();
    }

    /**
    * Sets the kuntaid of this vanhatkirjat.
    *
    * @param kuntaid the kuntaid of this vanhatkirjat
    */
    @Override
    public void setKuntaid(int kuntaid) {
        _vanhatkirjat.setKuntaid(kuntaid);
    }

    /**
    * Returns the maakuntaid of this vanhatkirjat.
    *
    * @return the maakuntaid of this vanhatkirjat
    */
    @Override
    public int getMaakuntaid() {
        return _vanhatkirjat.getMaakuntaid();
    }

    /**
    * Sets the maakuntaid of this vanhatkirjat.
    *
    * @param maakuntaid the maakuntaid of this vanhatkirjat
    */
    @Override
    public void setMaakuntaid(int maakuntaid) {
        _vanhatkirjat.setMaakuntaid(maakuntaid);
    }

    /**
    * Returns the lomakenum of this vanhatkirjat.
    *
    * @return the lomakenum of this vanhatkirjat
    */
    @Override
    public int getLomakenum() {
        return _vanhatkirjat.getLomakenum();
    }

    /**
    * Sets the lomakenum of this vanhatkirjat.
    *
    * @param lomakenum the lomakenum of this vanhatkirjat
    */
    @Override
    public void setLomakenum(int lomakenum) {
        _vanhatkirjat.setLomakenum(lomakenum);
    }

    /**
    * Returns the paivays of this vanhatkirjat.
    *
    * @return the paivays of this vanhatkirjat
    */
    @Override
    public java.util.Date getPaivays() {
        return _vanhatkirjat.getPaivays();
    }

    /**
    * Sets the paivays of this vanhatkirjat.
    *
    * @param paivays the paivays of this vanhatkirjat
    */
    @Override
    public void setPaivays(java.util.Date paivays) {
        _vanhatkirjat.setPaivays(paivays);
    }

    /**
    * Returns the kartkohde of this vanhatkirjat.
    *
    * @return the kartkohde of this vanhatkirjat
    */
    @Override
    public int getKartkohde() {
        return _vanhatkirjat.getKartkohde();
    }

    /**
    * Sets the kartkohde of this vanhatkirjat.
    *
    * @param kartkohde the kartkohde of this vanhatkirjat
    */
    @Override
    public void setKartkohde(int kartkohde) {
        _vanhatkirjat.setKartkohde(kartkohde);
    }

    /**
    * Returns the tekija of this vanhatkirjat.
    *
    * @return the tekija of this vanhatkirjat
    */
    @Override
    public java.lang.String getTekija() {
        return _vanhatkirjat.getTekija();
    }

    /**
    * Sets the tekija of this vanhatkirjat.
    *
    * @param tekija the tekija of this vanhatkirjat
    */
    @Override
    public void setTekija(java.lang.String tekija) {
        _vanhatkirjat.setTekija(tekija);
    }

    /**
    * Returns the teoknimi of this vanhatkirjat.
    *
    * @return the teoknimi of this vanhatkirjat
    */
    @Override
    public java.lang.String getTeoknimi() {
        return _vanhatkirjat.getTeoknimi();
    }

    /**
    * Sets the teoknimi of this vanhatkirjat.
    *
    * @param teoknimi the teoknimi of this vanhatkirjat
    */
    @Override
    public void setTeoknimi(java.lang.String teoknimi) {
        _vanhatkirjat.setTeoknimi(teoknimi);
    }

    /**
    * Returns the painovuosi of this vanhatkirjat.
    *
    * @return the painovuosi of this vanhatkirjat
    */
    @Override
    public int getPainovuosi() {
        return _vanhatkirjat.getPainovuosi();
    }

    /**
    * Sets the painovuosi of this vanhatkirjat.
    *
    * @param painovuosi the painovuosi of this vanhatkirjat
    */
    @Override
    public void setPainovuosi(int painovuosi) {
        _vanhatkirjat.setPainovuosi(painovuosi);
    }

    /**
    * Returns the painopaikka of this vanhatkirjat.
    *
    * @return the painopaikka of this vanhatkirjat
    */
    @Override
    public java.lang.String getPainopaikka() {
        return _vanhatkirjat.getPainopaikka();
    }

    /**
    * Sets the painopaikka of this vanhatkirjat.
    *
    * @param painopaikka the painopaikka of this vanhatkirjat
    */
    @Override
    public void setPainopaikka(java.lang.String painopaikka) {
        _vanhatkirjat.setPainopaikka(painopaikka);
    }

    /**
    * Returns the kirjapaino of this vanhatkirjat.
    *
    * @return the kirjapaino of this vanhatkirjat
    */
    @Override
    public java.lang.String getKirjapaino() {
        return _vanhatkirjat.getKirjapaino();
    }

    /**
    * Sets the kirjapaino of this vanhatkirjat.
    *
    * @param kirjapaino the kirjapaino of this vanhatkirjat
    */
    @Override
    public void setKirjapaino(java.lang.String kirjapaino) {
        _vanhatkirjat.setKirjapaino(kirjapaino);
    }

    /**
    * Returns the painosmerk of this vanhatkirjat.
    *
    * @return the painosmerk of this vanhatkirjat
    */
    @Override
    public int getPainosmerk() {
        return _vanhatkirjat.getPainosmerk();
    }

    /**
    * Sets the painosmerk of this vanhatkirjat.
    *
    * @param painosmerk the painosmerk of this vanhatkirjat
    */
    @Override
    public void setPainosmerk(int painosmerk) {
        _vanhatkirjat.setPainosmerk(painosmerk);
    }

    /**
    * Returns the imprimatur of this vanhatkirjat.
    *
    * @return the imprimatur of this vanhatkirjat
    */
    @Override
    public int getImprimatur() {
        return _vanhatkirjat.getImprimatur();
    }

    /**
    * Sets the imprimatur of this vanhatkirjat.
    *
    * @param imprimatur the imprimatur of this vanhatkirjat
    */
    @Override
    public void setImprimatur(int imprimatur) {
        _vanhatkirjat.setImprimatur(imprimatur);
    }

    /**
    * Returns the kuvitus of this vanhatkirjat.
    *
    * @return the kuvitus of this vanhatkirjat
    */
    @Override
    public int getKuvitus() {
        return _vanhatkirjat.getKuvitus();
    }

    /**
    * Sets the kuvitus of this vanhatkirjat.
    *
    * @param kuvitus the kuvitus of this vanhatkirjat
    */
    @Override
    public void setKuvitus(int kuvitus) {
        _vanhatkirjat.setKuvitus(kuvitus);
    }

    /**
    * Returns the kartat of this vanhatkirjat.
    *
    * @return the kartat of this vanhatkirjat
    */
    @Override
    public int getKartat() {
        return _vanhatkirjat.getKartat();
    }

    /**
    * Sets the kartat of this vanhatkirjat.
    *
    * @param kartat the kartat of this vanhatkirjat
    */
    @Override
    public void setKartat(int kartat) {
        _vanhatkirjat.setKartat(kartat);
    }

    /**
    * Returns the liitteita of this vanhatkirjat.
    *
    * @return the liitteita of this vanhatkirjat
    */
    @Override
    public int getLiitteita() {
        return _vanhatkirjat.getLiitteita();
    }

    /**
    * Sets the liitteita of this vanhatkirjat.
    *
    * @param liitteita the liitteita of this vanhatkirjat
    */
    @Override
    public void setLiitteita(int liitteita) {
        _vanhatkirjat.setLiitteita(liitteita);
    }

    /**
    * Returns the nimikirj of this vanhatkirjat.
    *
    * @return the nimikirj of this vanhatkirjat
    */
    @Override
    public java.lang.String getNimikirj() {
        return _vanhatkirjat.getNimikirj();
    }

    /**
    * Sets the nimikirj of this vanhatkirjat.
    *
    * @param nimikirj the nimikirj of this vanhatkirjat
    */
    @Override
    public void setNimikirj(java.lang.String nimikirj) {
        _vanhatkirjat.setNimikirj(nimikirj);
    }

    /**
    * Returns the sinetti of this vanhatkirjat.
    *
    * @return the sinetti of this vanhatkirjat
    */
    @Override
    public int getSinetti() {
        return _vanhatkirjat.getSinetti();
    }

    /**
    * Sets the sinetti of this vanhatkirjat.
    *
    * @param sinetti the sinetti of this vanhatkirjat
    */
    @Override
    public void setSinetti(int sinetti) {
        _vanhatkirjat.setSinetti(sinetti);
    }

    /**
    * Returns the leima of this vanhatkirjat.
    *
    * @return the leima of this vanhatkirjat
    */
    @Override
    public int getLeima() {
        return _vanhatkirjat.getLeima();
    }

    /**
    * Sets the leima of this vanhatkirjat.
    *
    * @param leima the leima of this vanhatkirjat
    */
    @Override
    public void setLeima(int leima) {
        _vanhatkirjat.setLeima(leima);
    }

    /**
    * Returns the exlibris of this vanhatkirjat.
    *
    * @return the exlibris of this vanhatkirjat
    */
    @Override
    public int getExlibris() {
        return _vanhatkirjat.getExlibris();
    }

    /**
    * Sets the exlibris of this vanhatkirjat.
    *
    * @param exlibris the exlibris of this vanhatkirjat
    */
    @Override
    public void setExlibris(int exlibris) {
        _vanhatkirjat.setExlibris(exlibris);
    }

    /**
    * Returns the hintamerk of this vanhatkirjat.
    *
    * @return the hintamerk of this vanhatkirjat
    */
    @Override
    public int getHintamerk() {
        return _vanhatkirjat.getHintamerk();
    }

    /**
    * Sets the hintamerk of this vanhatkirjat.
    *
    * @param hintamerk the hintamerk of this vanhatkirjat
    */
    @Override
    public void setHintamerk(int hintamerk) {
        _vanhatkirjat.setHintamerk(hintamerk);
    }

    /**
    * Returns the omiste of this vanhatkirjat.
    *
    * @return the omiste of this vanhatkirjat
    */
    @Override
    public java.lang.String getOmiste() {
        return _vanhatkirjat.getOmiste();
    }

    /**
    * Sets the omiste of this vanhatkirjat.
    *
    * @param omiste the omiste of this vanhatkirjat
    */
    @Override
    public void setOmiste(java.lang.String omiste) {
        _vanhatkirjat.setOmiste(omiste);
    }

    /**
    * Returns the reunamerk of this vanhatkirjat.
    *
    * @return the reunamerk of this vanhatkirjat
    */
    @Override
    public java.lang.String getReunamerk() {
        return _vanhatkirjat.getReunamerk();
    }

    /**
    * Sets the reunamerk of this vanhatkirjat.
    *
    * @param reunamerk the reunamerk of this vanhatkirjat
    */
    @Override
    public void setReunamerk(java.lang.String reunamerk) {
        _vanhatkirjat.setReunamerk(reunamerk);
    }

    /**
    * Returns the lisatieto of this vanhatkirjat.
    *
    * @return the lisatieto of this vanhatkirjat
    */
    @Override
    public java.lang.String getLisatieto() {
        return _vanhatkirjat.getLisatieto();
    }

    /**
    * Sets the lisatieto of this vanhatkirjat.
    *
    * @param lisatieto the lisatieto of this vanhatkirjat
    */
    @Override
    public void setLisatieto(java.lang.String lisatieto) {
        _vanhatkirjat.setLisatieto(lisatieto);
    }

    /**
    * Returns the lahosoite of this vanhatkirjat.
    *
    * @return the lahosoite of this vanhatkirjat
    */
    @Override
    public java.lang.String getLahosoite() {
        return _vanhatkirjat.getLahosoite();
    }

    /**
    * Sets the lahosoite of this vanhatkirjat.
    *
    * @param lahosoite the lahosoite of this vanhatkirjat
    */
    @Override
    public void setLahosoite(java.lang.String lahosoite) {
        _vanhatkirjat.setLahosoite(lahosoite);
    }

    /**
    * Returns the lahemail of this vanhatkirjat.
    *
    * @return the lahemail of this vanhatkirjat
    */
    @Override
    public java.lang.String getLahemail() {
        return _vanhatkirjat.getLahemail();
    }

    /**
    * Sets the lahemail of this vanhatkirjat.
    *
    * @param lahemail the lahemail of this vanhatkirjat
    */
    @Override
    public void setLahemail(java.lang.String lahemail) {
        _vanhatkirjat.setLahemail(lahemail);
    }

    /**
    * Returns the status of this vanhatkirjat.
    *
    * @return the status of this vanhatkirjat
    */
    @Override
    public int getStatus() {
        return _vanhatkirjat.getStatus();
    }

    /**
    * Sets the status of this vanhatkirjat.
    *
    * @param status the status of this vanhatkirjat
    */
    @Override
    public void setStatus(int status) {
        _vanhatkirjat.setStatus(status);
    }

    /**
    * Returns the kieliid of this vanhatkirjat.
    *
    * @return the kieliid of this vanhatkirjat
    */
    @Override
    public int getKieliid() {
        return _vanhatkirjat.getKieliid();
    }

    /**
    * Sets the kieliid of this vanhatkirjat.
    *
    * @param kieliid the kieliid of this vanhatkirjat
    */
    @Override
    public void setKieliid(int kieliid) {
        _vanhatkirjat.setKieliid(kieliid);
    }

    /**
    * Returns the kielestaid of this vanhatkirjat.
    *
    * @return the kielestaid of this vanhatkirjat
    */
    @Override
    public int getKielestaid() {
        return _vanhatkirjat.getKielestaid();
    }

    /**
    * Sets the kielestaid of this vanhatkirjat.
    *
    * @param kielestaid the kielestaid of this vanhatkirjat
    */
    @Override
    public void setKielestaid(int kielestaid) {
        _vanhatkirjat.setKielestaid(kielestaid);
    }

    /**
    * Returns the julklajiid of this vanhatkirjat.
    *
    * @return the julklajiid of this vanhatkirjat
    */
    @Override
    public int getJulklajiid() {
        return _vanhatkirjat.getJulklajiid();
    }

    /**
    * Sets the julklajiid of this vanhatkirjat.
    *
    * @param julklajiid the julklajiid of this vanhatkirjat
    */
    @Override
    public void setJulklajiid(int julklajiid) {
        _vanhatkirjat.setJulklajiid(julklajiid);
    }

    /**
    * Returns the kuntoid of this vanhatkirjat.
    *
    * @return the kuntoid of this vanhatkirjat
    */
    @Override
    public int getKuntoid() {
        return _vanhatkirjat.getKuntoid();
    }

    /**
    * Sets the kuntoid of this vanhatkirjat.
    *
    * @param kuntoid the kuntoid of this vanhatkirjat
    */
    @Override
    public void setKuntoid(int kuntoid) {
        _vanhatkirjat.setKuntoid(kuntoid);
    }

    /**
    * Returns the puuteid of this vanhatkirjat.
    *
    * @return the puuteid of this vanhatkirjat
    */
    @Override
    public int getPuuteid() {
        return _vanhatkirjat.getPuuteid();
    }

    /**
    * Sets the puuteid of this vanhatkirjat.
    *
    * @param puuteid the puuteid of this vanhatkirjat
    */
    @Override
    public void setPuuteid(int puuteid) {
        _vanhatkirjat.setPuuteid(puuteid);
    }

    /**
    * Returns the teospkid of this vanhatkirjat.
    *
    * @return the teospkid of this vanhatkirjat
    */
    @Override
    public int getTeospkid() {
        return _vanhatkirjat.getTeospkid();
    }

    /**
    * Sets the teospkid of this vanhatkirjat.
    *
    * @param teospkid the teospkid of this vanhatkirjat
    */
    @Override
    public void setTeospkid(int teospkid) {
        _vanhatkirjat.setTeospkid(teospkid);
    }

    /**
    * Returns the sidonta of this vanhatkirjat.
    *
    * @return the sidonta of this vanhatkirjat
    */
    @Override
    public int getSidonta() {
        return _vanhatkirjat.getSidonta();
    }

    /**
    * Sets the sidonta of this vanhatkirjat.
    *
    * @param sidonta the sidonta of this vanhatkirjat
    */
    @Override
    public void setSidonta(int sidonta) {
        _vanhatkirjat.setSidonta(sidonta);
    }

    /**
    * Returns the kokoelma of this vanhatkirjat.
    *
    * @return the kokoelma of this vanhatkirjat
    */
    @Override
    public java.lang.String getKokoelma() {
        return _vanhatkirjat.getKokoelma();
    }

    /**
    * Sets the kokoelma of this vanhatkirjat.
    *
    * @param kokoelma the kokoelma of this vanhatkirjat
    */
    @Override
    public void setKokoelma(java.lang.String kokoelma) {
        _vanhatkirjat.setKokoelma(kokoelma);
    }

    /**
    * Returns the poistettu of this vanhatkirjat.
    *
    * @return the poistettu of this vanhatkirjat
    */
    @Override
    public java.util.Date getPoistettu() {
        return _vanhatkirjat.getPoistettu();
    }

    /**
    * Sets the poistettu of this vanhatkirjat.
    *
    * @param poistettu the poistettu of this vanhatkirjat
    */
    @Override
    public void setPoistettu(java.util.Date poistettu) {
        _vanhatkirjat.setPoistettu(poistettu);
    }

    /**
    * Returns the muokattu of this vanhatkirjat.
    *
    * @return the muokattu of this vanhatkirjat
    */
    @Override
    public java.util.Date getMuokattu() {
        return _vanhatkirjat.getMuokattu();
    }

    /**
    * Sets the muokattu of this vanhatkirjat.
    *
    * @param muokattu the muokattu of this vanhatkirjat
    */
    @Override
    public void setMuokattu(java.util.Date muokattu) {
        _vanhatkirjat.setMuokattu(muokattu);
    }

    @Override
    public boolean isNew() {
        return _vanhatkirjat.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _vanhatkirjat.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _vanhatkirjat.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _vanhatkirjat.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _vanhatkirjat.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _vanhatkirjat.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _vanhatkirjat.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _vanhatkirjat.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _vanhatkirjat.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _vanhatkirjat.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _vanhatkirjat.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new VanhatkirjatWrapper((Vanhatkirjat) _vanhatkirjat.clone());
    }

    @Override
    public int compareTo(fi.csc.avaa.khl.db.model.Vanhatkirjat vanhatkirjat) {
        return _vanhatkirjat.compareTo(vanhatkirjat);
    }

    @Override
    public int hashCode() {
        return _vanhatkirjat.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<fi.csc.avaa.khl.db.model.Vanhatkirjat> toCacheModel() {
        return _vanhatkirjat.toCacheModel();
    }

    @Override
    public fi.csc.avaa.khl.db.model.Vanhatkirjat toEscapedModel() {
        return new VanhatkirjatWrapper(_vanhatkirjat.toEscapedModel());
    }

    @Override
    public fi.csc.avaa.khl.db.model.Vanhatkirjat toUnescapedModel() {
        return new VanhatkirjatWrapper(_vanhatkirjat.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _vanhatkirjat.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _vanhatkirjat.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _vanhatkirjat.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof VanhatkirjatWrapper)) {
            return false;
        }

        VanhatkirjatWrapper vanhatkirjatWrapper = (VanhatkirjatWrapper) obj;

        if (Validator.equals(_vanhatkirjat, vanhatkirjatWrapper._vanhatkirjat)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Vanhatkirjat getWrappedVanhatkirjat() {
        return _vanhatkirjat;
    }

    @Override
    public Vanhatkirjat getWrappedModel() {
        return _vanhatkirjat;
    }

    @Override
    public void resetOriginalValues() {
        _vanhatkirjat.resetOriginalValues();
    }
}
