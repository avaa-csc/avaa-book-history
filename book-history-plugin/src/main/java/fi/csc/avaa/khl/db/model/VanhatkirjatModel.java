package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Vanhatkirjat service. Represents a row in the &quot;vanhatkirjat&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link fi.csc.avaa.khl.db.model.impl.VanhatkirjatModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link fi.csc.avaa.khl.db.model.impl.VanhatkirjatImpl}.
 * </p>
 *
 * @author CSC
 * @see Vanhatkirjat
 * @see fi.csc.avaa.khl.db.model.impl.VanhatkirjatImpl
 * @see fi.csc.avaa.khl.db.model.impl.VanhatkirjatModelImpl
 * @generated
 */
public interface VanhatkirjatModel extends BaseModel<Vanhatkirjat> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a vanhatkirjat model instance should use the {@link Vanhatkirjat} interface instead.
     */

    /**
     * Returns the primary key of this vanhatkirjat.
     *
     * @return the primary key of this vanhatkirjat
     */
    public int getPrimaryKey();

    /**
     * Sets the primary key of this vanhatkirjat.
     *
     * @param primaryKey the primary key of this vanhatkirjat
     */
    public void setPrimaryKey(int primaryKey);

    /**
     * Returns the vkid of this vanhatkirjat.
     *
     * @return the vkid of this vanhatkirjat
     */
    public int getVkid();

    /**
     * Sets the vkid of this vanhatkirjat.
     *
     * @param vkid the vkid of this vanhatkirjat
     */
    public void setVkid(int vkid);

    /**
     * Returns the kuntaid of this vanhatkirjat.
     *
     * @return the kuntaid of this vanhatkirjat
     */
    public int getKuntaid();

    /**
     * Sets the kuntaid of this vanhatkirjat.
     *
     * @param kuntaid the kuntaid of this vanhatkirjat
     */
    public void setKuntaid(int kuntaid);

    /**
     * Returns the maakuntaid of this vanhatkirjat.
     *
     * @return the maakuntaid of this vanhatkirjat
     */
    public int getMaakuntaid();

    /**
     * Sets the maakuntaid of this vanhatkirjat.
     *
     * @param maakuntaid the maakuntaid of this vanhatkirjat
     */
    public void setMaakuntaid(int maakuntaid);

    /**
     * Returns the lomakenum of this vanhatkirjat.
     *
     * @return the lomakenum of this vanhatkirjat
     */
    public int getLomakenum();

    /**
     * Sets the lomakenum of this vanhatkirjat.
     *
     * @param lomakenum the lomakenum of this vanhatkirjat
     */
    public void setLomakenum(int lomakenum);

    /**
     * Returns the paivays of this vanhatkirjat.
     *
     * @return the paivays of this vanhatkirjat
     */
    public Date getPaivays();

    /**
     * Sets the paivays of this vanhatkirjat.
     *
     * @param paivays the paivays of this vanhatkirjat
     */
    public void setPaivays(Date paivays);

    /**
     * Returns the kartkohde of this vanhatkirjat.
     *
     * @return the kartkohde of this vanhatkirjat
     */
    public int getKartkohde();

    /**
     * Sets the kartkohde of this vanhatkirjat.
     *
     * @param kartkohde the kartkohde of this vanhatkirjat
     */
    public void setKartkohde(int kartkohde);

    /**
     * Returns the tekija of this vanhatkirjat.
     *
     * @return the tekija of this vanhatkirjat
     */
    @AutoEscape
    public String getTekija();

    /**
     * Sets the tekija of this vanhatkirjat.
     *
     * @param tekija the tekija of this vanhatkirjat
     */
    public void setTekija(String tekija);

    /**
     * Returns the teoknimi of this vanhatkirjat.
     *
     * @return the teoknimi of this vanhatkirjat
     */
    @AutoEscape
    public String getTeoknimi();

    /**
     * Sets the teoknimi of this vanhatkirjat.
     *
     * @param teoknimi the teoknimi of this vanhatkirjat
     */
    public void setTeoknimi(String teoknimi);

    /**
     * Returns the painovuosi of this vanhatkirjat.
     *
     * @return the painovuosi of this vanhatkirjat
     */
    public int getPainovuosi();

    /**
     * Sets the painovuosi of this vanhatkirjat.
     *
     * @param painovuosi the painovuosi of this vanhatkirjat
     */
    public void setPainovuosi(int painovuosi);

    /**
     * Returns the painopaikka of this vanhatkirjat.
     *
     * @return the painopaikka of this vanhatkirjat
     */
    @AutoEscape
    public String getPainopaikka();

    /**
     * Sets the painopaikka of this vanhatkirjat.
     *
     * @param painopaikka the painopaikka of this vanhatkirjat
     */
    public void setPainopaikka(String painopaikka);

    /**
     * Returns the kirjapaino of this vanhatkirjat.
     *
     * @return the kirjapaino of this vanhatkirjat
     */
    @AutoEscape
    public String getKirjapaino();

    /**
     * Sets the kirjapaino of this vanhatkirjat.
     *
     * @param kirjapaino the kirjapaino of this vanhatkirjat
     */
    public void setKirjapaino(String kirjapaino);

    /**
     * Returns the painosmerk of this vanhatkirjat.
     *
     * @return the painosmerk of this vanhatkirjat
     */
    public int getPainosmerk();

    /**
     * Sets the painosmerk of this vanhatkirjat.
     *
     * @param painosmerk the painosmerk of this vanhatkirjat
     */
    public void setPainosmerk(int painosmerk);

    /**
     * Returns the imprimatur of this vanhatkirjat.
     *
     * @return the imprimatur of this vanhatkirjat
     */
    public int getImprimatur();

    /**
     * Sets the imprimatur of this vanhatkirjat.
     *
     * @param imprimatur the imprimatur of this vanhatkirjat
     */
    public void setImprimatur(int imprimatur);

    /**
     * Returns the kuvitus of this vanhatkirjat.
     *
     * @return the kuvitus of this vanhatkirjat
     */
    public int getKuvitus();

    /**
     * Sets the kuvitus of this vanhatkirjat.
     *
     * @param kuvitus the kuvitus of this vanhatkirjat
     */
    public void setKuvitus(int kuvitus);

    /**
     * Returns the kartat of this vanhatkirjat.
     *
     * @return the kartat of this vanhatkirjat
     */
    public int getKartat();

    /**
     * Sets the kartat of this vanhatkirjat.
     *
     * @param kartat the kartat of this vanhatkirjat
     */
    public void setKartat(int kartat);

    /**
     * Returns the liitteita of this vanhatkirjat.
     *
     * @return the liitteita of this vanhatkirjat
     */
    public int getLiitteita();

    /**
     * Sets the liitteita of this vanhatkirjat.
     *
     * @param liitteita the liitteita of this vanhatkirjat
     */
    public void setLiitteita(int liitteita);

    /**
     * Returns the nimikirj of this vanhatkirjat.
     *
     * @return the nimikirj of this vanhatkirjat
     */
    @AutoEscape
    public String getNimikirj();

    /**
     * Sets the nimikirj of this vanhatkirjat.
     *
     * @param nimikirj the nimikirj of this vanhatkirjat
     */
    public void setNimikirj(String nimikirj);

    /**
     * Returns the sinetti of this vanhatkirjat.
     *
     * @return the sinetti of this vanhatkirjat
     */
    public int getSinetti();

    /**
     * Sets the sinetti of this vanhatkirjat.
     *
     * @param sinetti the sinetti of this vanhatkirjat
     */
    public void setSinetti(int sinetti);

    /**
     * Returns the leima of this vanhatkirjat.
     *
     * @return the leima of this vanhatkirjat
     */
    public int getLeima();

    /**
     * Sets the leima of this vanhatkirjat.
     *
     * @param leima the leima of this vanhatkirjat
     */
    public void setLeima(int leima);

    /**
     * Returns the exlibris of this vanhatkirjat.
     *
     * @return the exlibris of this vanhatkirjat
     */
    public int getExlibris();

    /**
     * Sets the exlibris of this vanhatkirjat.
     *
     * @param exlibris the exlibris of this vanhatkirjat
     */
    public void setExlibris(int exlibris);

    /**
     * Returns the hintamerk of this vanhatkirjat.
     *
     * @return the hintamerk of this vanhatkirjat
     */
    public int getHintamerk();

    /**
     * Sets the hintamerk of this vanhatkirjat.
     *
     * @param hintamerk the hintamerk of this vanhatkirjat
     */
    public void setHintamerk(int hintamerk);

    /**
     * Returns the omiste of this vanhatkirjat.
     *
     * @return the omiste of this vanhatkirjat
     */
    @AutoEscape
    public String getOmiste();

    /**
     * Sets the omiste of this vanhatkirjat.
     *
     * @param omiste the omiste of this vanhatkirjat
     */
    public void setOmiste(String omiste);

    /**
     * Returns the reunamerk of this vanhatkirjat.
     *
     * @return the reunamerk of this vanhatkirjat
     */
    @AutoEscape
    public String getReunamerk();

    /**
     * Sets the reunamerk of this vanhatkirjat.
     *
     * @param reunamerk the reunamerk of this vanhatkirjat
     */
    public void setReunamerk(String reunamerk);

    /**
     * Returns the lisatieto of this vanhatkirjat.
     *
     * @return the lisatieto of this vanhatkirjat
     */
    @AutoEscape
    public String getLisatieto();

    /**
     * Sets the lisatieto of this vanhatkirjat.
     *
     * @param lisatieto the lisatieto of this vanhatkirjat
     */
    public void setLisatieto(String lisatieto);

    /**
     * Returns the lahosoite of this vanhatkirjat.
     *
     * @return the lahosoite of this vanhatkirjat
     */
    @AutoEscape
    public String getLahosoite();

    /**
     * Sets the lahosoite of this vanhatkirjat.
     *
     * @param lahosoite the lahosoite of this vanhatkirjat
     */
    public void setLahosoite(String lahosoite);

    /**
     * Returns the lahemail of this vanhatkirjat.
     *
     * @return the lahemail of this vanhatkirjat
     */
    @AutoEscape
    public String getLahemail();

    /**
     * Sets the lahemail of this vanhatkirjat.
     *
     * @param lahemail the lahemail of this vanhatkirjat
     */
    public void setLahemail(String lahemail);

    /**
     * Returns the status of this vanhatkirjat.
     *
     * @return the status of this vanhatkirjat
     */
    public int getStatus();

    /**
     * Sets the status of this vanhatkirjat.
     *
     * @param status the status of this vanhatkirjat
     */
    public void setStatus(int status);

    /**
     * Returns the kieliid of this vanhatkirjat.
     *
     * @return the kieliid of this vanhatkirjat
     */
    public int getKieliid();

    /**
     * Sets the kieliid of this vanhatkirjat.
     *
     * @param kieliid the kieliid of this vanhatkirjat
     */
    public void setKieliid(int kieliid);

    /**
     * Returns the kielestaid of this vanhatkirjat.
     *
     * @return the kielestaid of this vanhatkirjat
     */
    public int getKielestaid();

    /**
     * Sets the kielestaid of this vanhatkirjat.
     *
     * @param kielestaid the kielestaid of this vanhatkirjat
     */
    public void setKielestaid(int kielestaid);

    /**
     * Returns the julklajiid of this vanhatkirjat.
     *
     * @return the julklajiid of this vanhatkirjat
     */
    public int getJulklajiid();

    /**
     * Sets the julklajiid of this vanhatkirjat.
     *
     * @param julklajiid the julklajiid of this vanhatkirjat
     */
    public void setJulklajiid(int julklajiid);

    /**
     * Returns the kuntoid of this vanhatkirjat.
     *
     * @return the kuntoid of this vanhatkirjat
     */
    public int getKuntoid();

    /**
     * Sets the kuntoid of this vanhatkirjat.
     *
     * @param kuntoid the kuntoid of this vanhatkirjat
     */
    public void setKuntoid(int kuntoid);

    /**
     * Returns the puuteid of this vanhatkirjat.
     *
     * @return the puuteid of this vanhatkirjat
     */
    public int getPuuteid();

    /**
     * Sets the puuteid of this vanhatkirjat.
     *
     * @param puuteid the puuteid of this vanhatkirjat
     */
    public void setPuuteid(int puuteid);

    /**
     * Returns the teospkid of this vanhatkirjat.
     *
     * @return the teospkid of this vanhatkirjat
     */
    public int getTeospkid();

    /**
     * Sets the teospkid of this vanhatkirjat.
     *
     * @param teospkid the teospkid of this vanhatkirjat
     */
    public void setTeospkid(int teospkid);

    /**
     * Returns the sidonta of this vanhatkirjat.
     *
     * @return the sidonta of this vanhatkirjat
     */
    public int getSidonta();

    /**
     * Sets the sidonta of this vanhatkirjat.
     *
     * @param sidonta the sidonta of this vanhatkirjat
     */
    public void setSidonta(int sidonta);

    /**
     * Returns the kokoelma of this vanhatkirjat.
     *
     * @return the kokoelma of this vanhatkirjat
     */
    @AutoEscape
    public String getKokoelma();

    /**
     * Sets the kokoelma of this vanhatkirjat.
     *
     * @param kokoelma the kokoelma of this vanhatkirjat
     */
    public void setKokoelma(String kokoelma);

    /**
     * Returns the poistettu of this vanhatkirjat.
     *
     * @return the poistettu of this vanhatkirjat
     */
    public Date getPoistettu();

    /**
     * Sets the poistettu of this vanhatkirjat.
     *
     * @param poistettu the poistettu of this vanhatkirjat
     */
    public void setPoistettu(Date poistettu);

    /**
     * Returns the muokattu of this vanhatkirjat.
     *
     * @return the muokattu of this vanhatkirjat
     */
    public Date getMuokattu();

    /**
     * Sets the muokattu of this vanhatkirjat.
     *
     * @param muokattu the muokattu of this vanhatkirjat
     */
    public void setMuokattu(Date muokattu);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(fi.csc.avaa.khl.db.model.Vanhatkirjat vanhatkirjat);

    @Override
    public int hashCode();

    @Override
    public CacheModel<fi.csc.avaa.khl.db.model.Vanhatkirjat> toCacheModel();

    @Override
    public fi.csc.avaa.khl.db.model.Vanhatkirjat toEscapedModel();

    @Override
    public fi.csc.avaa.khl.db.model.Vanhatkirjat toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
