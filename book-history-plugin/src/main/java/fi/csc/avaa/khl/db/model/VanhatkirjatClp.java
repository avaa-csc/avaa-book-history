package fi.csc.avaa.khl.db.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import fi.csc.avaa.khl.db.service.ClpSerializer;
import fi.csc.avaa.khl.db.service.VanhatkirjatLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class VanhatkirjatClp extends BaseModelImpl<Vanhatkirjat>
    implements Vanhatkirjat {
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
    private BaseModel<?> _vanhatkirjatRemoteModel;
    private Class<?> _clpSerializerClass = fi.csc.avaa.khl.db.service.ClpSerializer.class;

    public VanhatkirjatClp() {
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
    public int getPrimaryKey() {
        return _vkid;
    }

    @Override
    public void setPrimaryKey(int primaryKey) {
        setVkid(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _vkid;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Integer) primaryKeyObj).intValue());
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

    @Override
    public int getVkid() {
        return _vkid;
    }

    @Override
    public void setVkid(int vkid) {
        _vkid = vkid;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setVkid", int.class);

                method.invoke(_vanhatkirjatRemoteModel, vkid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getKuntaid() {
        return _kuntaid;
    }

    @Override
    public void setKuntaid(int kuntaid) {
        _kuntaid = kuntaid;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setKuntaid", int.class);

                method.invoke(_vanhatkirjatRemoteModel, kuntaid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getMaakuntaid() {
        return _maakuntaid;
    }

    @Override
    public void setMaakuntaid(int maakuntaid) {
        _maakuntaid = maakuntaid;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setMaakuntaid", int.class);

                method.invoke(_vanhatkirjatRemoteModel, maakuntaid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getLomakenum() {
        return _lomakenum;
    }

    @Override
    public void setLomakenum(int lomakenum) {
        _lomakenum = lomakenum;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setLomakenum", int.class);

                method.invoke(_vanhatkirjatRemoteModel, lomakenum);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getPaivays() {
        return _paivays;
    }

    @Override
    public void setPaivays(Date paivays) {
        _paivays = paivays;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setPaivays", Date.class);

                method.invoke(_vanhatkirjatRemoteModel, paivays);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getKartkohde() {
        return _kartkohde;
    }

    @Override
    public void setKartkohde(int kartkohde) {
        _kartkohde = kartkohde;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setKartkohde", int.class);

                method.invoke(_vanhatkirjatRemoteModel, kartkohde);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTekija() {
        return _tekija;
    }

    @Override
    public void setTekija(String tekija) {
        _tekija = tekija;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setTekija", String.class);

                method.invoke(_vanhatkirjatRemoteModel, tekija);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTeoknimi() {
        return _teoknimi;
    }

    @Override
    public void setTeoknimi(String teoknimi) {
        _teoknimi = teoknimi;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setTeoknimi", String.class);

                method.invoke(_vanhatkirjatRemoteModel, teoknimi);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getPainovuosi() {
        return _painovuosi;
    }

    @Override
    public void setPainovuosi(int painovuosi) {
        _painovuosi = painovuosi;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setPainovuosi", int.class);

                method.invoke(_vanhatkirjatRemoteModel, painovuosi);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPainopaikka() {
        return _painopaikka;
    }

    @Override
    public void setPainopaikka(String painopaikka) {
        _painopaikka = painopaikka;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setPainopaikka", String.class);

                method.invoke(_vanhatkirjatRemoteModel, painopaikka);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getKirjapaino() {
        return _kirjapaino;
    }

    @Override
    public void setKirjapaino(String kirjapaino) {
        _kirjapaino = kirjapaino;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setKirjapaino", String.class);

                method.invoke(_vanhatkirjatRemoteModel, kirjapaino);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getPainosmerk() {
        return _painosmerk;
    }

    @Override
    public void setPainosmerk(int painosmerk) {
        _painosmerk = painosmerk;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setPainosmerk", int.class);

                method.invoke(_vanhatkirjatRemoteModel, painosmerk);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getImprimatur() {
        return _imprimatur;
    }

    @Override
    public void setImprimatur(int imprimatur) {
        _imprimatur = imprimatur;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setImprimatur", int.class);

                method.invoke(_vanhatkirjatRemoteModel, imprimatur);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getKuvitus() {
        return _kuvitus;
    }

    @Override
    public void setKuvitus(int kuvitus) {
        _kuvitus = kuvitus;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setKuvitus", int.class);

                method.invoke(_vanhatkirjatRemoteModel, kuvitus);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getKartat() {
        return _kartat;
    }

    @Override
    public void setKartat(int kartat) {
        _kartat = kartat;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setKartat", int.class);

                method.invoke(_vanhatkirjatRemoteModel, kartat);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getLiitteita() {
        return _liitteita;
    }

    @Override
    public void setLiitteita(int liitteita) {
        _liitteita = liitteita;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setLiitteita", int.class);

                method.invoke(_vanhatkirjatRemoteModel, liitteita);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getNimikirj() {
        return _nimikirj;
    }

    @Override
    public void setNimikirj(String nimikirj) {
        _nimikirj = nimikirj;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setNimikirj", String.class);

                method.invoke(_vanhatkirjatRemoteModel, nimikirj);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getSinetti() {
        return _sinetti;
    }

    @Override
    public void setSinetti(int sinetti) {
        _sinetti = sinetti;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setSinetti", int.class);

                method.invoke(_vanhatkirjatRemoteModel, sinetti);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getLeima() {
        return _leima;
    }

    @Override
    public void setLeima(int leima) {
        _leima = leima;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setLeima", int.class);

                method.invoke(_vanhatkirjatRemoteModel, leima);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getExlibris() {
        return _exlibris;
    }

    @Override
    public void setExlibris(int exlibris) {
        _exlibris = exlibris;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setExlibris", int.class);

                method.invoke(_vanhatkirjatRemoteModel, exlibris);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getHintamerk() {
        return _hintamerk;
    }

    @Override
    public void setHintamerk(int hintamerk) {
        _hintamerk = hintamerk;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setHintamerk", int.class);

                method.invoke(_vanhatkirjatRemoteModel, hintamerk);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getOmiste() {
        return _omiste;
    }

    @Override
    public void setOmiste(String omiste) {
        _omiste = omiste;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setOmiste", String.class);

                method.invoke(_vanhatkirjatRemoteModel, omiste);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getReunamerk() {
        return _reunamerk;
    }

    @Override
    public void setReunamerk(String reunamerk) {
        _reunamerk = reunamerk;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setReunamerk", String.class);

                method.invoke(_vanhatkirjatRemoteModel, reunamerk);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLisatieto() {
        return _lisatieto;
    }

    @Override
    public void setLisatieto(String lisatieto) {
        _lisatieto = lisatieto;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setLisatieto", String.class);

                method.invoke(_vanhatkirjatRemoteModel, lisatieto);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLahosoite() {
        return _lahosoite;
    }

    @Override
    public void setLahosoite(String lahosoite) {
        _lahosoite = lahosoite;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setLahosoite", String.class);

                method.invoke(_vanhatkirjatRemoteModel, lahosoite);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getLahemail() {
        return _lahemail;
    }

    @Override
    public void setLahemail(String lahemail) {
        _lahemail = lahemail;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setLahemail", String.class);

                method.invoke(_vanhatkirjatRemoteModel, lahemail);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getStatus() {
        return _status;
    }

    @Override
    public void setStatus(int status) {
        _status = status;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", int.class);

                method.invoke(_vanhatkirjatRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getKieliid() {
        return _kieliid;
    }

    @Override
    public void setKieliid(int kieliid) {
        _kieliid = kieliid;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setKieliid", int.class);

                method.invoke(_vanhatkirjatRemoteModel, kieliid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getKielestaid() {
        return _kielestaid;
    }

    @Override
    public void setKielestaid(int kielestaid) {
        _kielestaid = kielestaid;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setKielestaid", int.class);

                method.invoke(_vanhatkirjatRemoteModel, kielestaid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getJulklajiid() {
        return _julklajiid;
    }

    @Override
    public void setJulklajiid(int julklajiid) {
        _julklajiid = julklajiid;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setJulklajiid", int.class);

                method.invoke(_vanhatkirjatRemoteModel, julklajiid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getKuntoid() {
        return _kuntoid;
    }

    @Override
    public void setKuntoid(int kuntoid) {
        _kuntoid = kuntoid;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setKuntoid", int.class);

                method.invoke(_vanhatkirjatRemoteModel, kuntoid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getPuuteid() {
        return _puuteid;
    }

    @Override
    public void setPuuteid(int puuteid) {
        _puuteid = puuteid;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setPuuteid", int.class);

                method.invoke(_vanhatkirjatRemoteModel, puuteid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getTeospkid() {
        return _teospkid;
    }

    @Override
    public void setTeospkid(int teospkid) {
        _teospkid = teospkid;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setTeospkid", int.class);

                method.invoke(_vanhatkirjatRemoteModel, teospkid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getSidonta() {
        return _sidonta;
    }

    @Override
    public void setSidonta(int sidonta) {
        _sidonta = sidonta;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setSidonta", int.class);

                method.invoke(_vanhatkirjatRemoteModel, sidonta);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getKokoelma() {
        return _kokoelma;
    }

    @Override
    public void setKokoelma(String kokoelma) {
        _kokoelma = kokoelma;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setKokoelma", String.class);

                method.invoke(_vanhatkirjatRemoteModel, kokoelma);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getPoistettu() {
        return _poistettu;
    }

    @Override
    public void setPoistettu(Date poistettu) {
        _poistettu = poistettu;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setPoistettu", Date.class);

                method.invoke(_vanhatkirjatRemoteModel, poistettu);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getMuokattu() {
        return _muokattu;
    }

    @Override
    public void setMuokattu(Date muokattu) {
        _muokattu = muokattu;

        if (_vanhatkirjatRemoteModel != null) {
            try {
                Class<?> clazz = _vanhatkirjatRemoteModel.getClass();

                Method method = clazz.getMethod("setMuokattu", Date.class);

                method.invoke(_vanhatkirjatRemoteModel, muokattu);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getVanhatkirjatRemoteModel() {
        return _vanhatkirjatRemoteModel;
    }

    public void setVanhatkirjatRemoteModel(BaseModel<?> vanhatkirjatRemoteModel) {
        _vanhatkirjatRemoteModel = vanhatkirjatRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _vanhatkirjatRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_vanhatkirjatRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            VanhatkirjatLocalServiceUtil.addVanhatkirjat(this);
        } else {
            VanhatkirjatLocalServiceUtil.updateVanhatkirjat(this);
        }
    }

    @Override
    public Vanhatkirjat toEscapedModel() {
        return (Vanhatkirjat) ProxyUtil.newProxyInstance(Vanhatkirjat.class.getClassLoader(),
            new Class[] { Vanhatkirjat.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        VanhatkirjatClp clone = new VanhatkirjatClp();

        clone.setVkid(getVkid());
        clone.setKuntaid(getKuntaid());
        clone.setMaakuntaid(getMaakuntaid());
        clone.setLomakenum(getLomakenum());
        clone.setPaivays(getPaivays());
        clone.setKartkohde(getKartkohde());
        clone.setTekija(getTekija());
        clone.setTeoknimi(getTeoknimi());
        clone.setPainovuosi(getPainovuosi());
        clone.setPainopaikka(getPainopaikka());
        clone.setKirjapaino(getKirjapaino());
        clone.setPainosmerk(getPainosmerk());
        clone.setImprimatur(getImprimatur());
        clone.setKuvitus(getKuvitus());
        clone.setKartat(getKartat());
        clone.setLiitteita(getLiitteita());
        clone.setNimikirj(getNimikirj());
        clone.setSinetti(getSinetti());
        clone.setLeima(getLeima());
        clone.setExlibris(getExlibris());
        clone.setHintamerk(getHintamerk());
        clone.setOmiste(getOmiste());
        clone.setReunamerk(getReunamerk());
        clone.setLisatieto(getLisatieto());
        clone.setLahosoite(getLahosoite());
        clone.setLahemail(getLahemail());
        clone.setStatus(getStatus());
        clone.setKieliid(getKieliid());
        clone.setKielestaid(getKielestaid());
        clone.setJulklajiid(getJulklajiid());
        clone.setKuntoid(getKuntoid());
        clone.setPuuteid(getPuuteid());
        clone.setTeospkid(getTeospkid());
        clone.setSidonta(getSidonta());
        clone.setKokoelma(getKokoelma());
        clone.setPoistettu(getPoistettu());
        clone.setMuokattu(getMuokattu());

        return clone;
    }

    @Override
    public int compareTo(Vanhatkirjat vanhatkirjat) {
        int primaryKey = vanhatkirjat.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof VanhatkirjatClp)) {
            return false;
        }

        VanhatkirjatClp vanhatkirjat = (VanhatkirjatClp) obj;

        int primaryKey = vanhatkirjat.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(75);

        sb.append("{vkid=");
        sb.append(getVkid());
        sb.append(", kuntaid=");
        sb.append(getKuntaid());
        sb.append(", maakuntaid=");
        sb.append(getMaakuntaid());
        sb.append(", lomakenum=");
        sb.append(getLomakenum());
        sb.append(", paivays=");
        sb.append(getPaivays());
        sb.append(", kartkohde=");
        sb.append(getKartkohde());
        sb.append(", tekija=");
        sb.append(getTekija());
        sb.append(", teoknimi=");
        sb.append(getTeoknimi());
        sb.append(", painovuosi=");
        sb.append(getPainovuosi());
        sb.append(", painopaikka=");
        sb.append(getPainopaikka());
        sb.append(", kirjapaino=");
        sb.append(getKirjapaino());
        sb.append(", painosmerk=");
        sb.append(getPainosmerk());
        sb.append(", imprimatur=");
        sb.append(getImprimatur());
        sb.append(", kuvitus=");
        sb.append(getKuvitus());
        sb.append(", kartat=");
        sb.append(getKartat());
        sb.append(", liitteita=");
        sb.append(getLiitteita());
        sb.append(", nimikirj=");
        sb.append(getNimikirj());
        sb.append(", sinetti=");
        sb.append(getSinetti());
        sb.append(", leima=");
        sb.append(getLeima());
        sb.append(", exlibris=");
        sb.append(getExlibris());
        sb.append(", hintamerk=");
        sb.append(getHintamerk());
        sb.append(", omiste=");
        sb.append(getOmiste());
        sb.append(", reunamerk=");
        sb.append(getReunamerk());
        sb.append(", lisatieto=");
        sb.append(getLisatieto());
        sb.append(", lahosoite=");
        sb.append(getLahosoite());
        sb.append(", lahemail=");
        sb.append(getLahemail());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", kieliid=");
        sb.append(getKieliid());
        sb.append(", kielestaid=");
        sb.append(getKielestaid());
        sb.append(", julklajiid=");
        sb.append(getJulklajiid());
        sb.append(", kuntoid=");
        sb.append(getKuntoid());
        sb.append(", puuteid=");
        sb.append(getPuuteid());
        sb.append(", teospkid=");
        sb.append(getTeospkid());
        sb.append(", sidonta=");
        sb.append(getSidonta());
        sb.append(", kokoelma=");
        sb.append(getKokoelma());
        sb.append(", poistettu=");
        sb.append(getPoistettu());
        sb.append(", muokattu=");
        sb.append(getMuokattu());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(115);

        sb.append("<model><model-name>");
        sb.append("fi.csc.avaa.khl.db.model.Vanhatkirjat");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>vkid</column-name><column-value><![CDATA[");
        sb.append(getVkid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kuntaid</column-name><column-value><![CDATA[");
        sb.append(getKuntaid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>maakuntaid</column-name><column-value><![CDATA[");
        sb.append(getMaakuntaid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lomakenum</column-name><column-value><![CDATA[");
        sb.append(getLomakenum());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>paivays</column-name><column-value><![CDATA[");
        sb.append(getPaivays());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kartkohde</column-name><column-value><![CDATA[");
        sb.append(getKartkohde());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tekija</column-name><column-value><![CDATA[");
        sb.append(getTekija());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>teoknimi</column-name><column-value><![CDATA[");
        sb.append(getTeoknimi());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>painovuosi</column-name><column-value><![CDATA[");
        sb.append(getPainovuosi());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>painopaikka</column-name><column-value><![CDATA[");
        sb.append(getPainopaikka());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kirjapaino</column-name><column-value><![CDATA[");
        sb.append(getKirjapaino());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>painosmerk</column-name><column-value><![CDATA[");
        sb.append(getPainosmerk());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>imprimatur</column-name><column-value><![CDATA[");
        sb.append(getImprimatur());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kuvitus</column-name><column-value><![CDATA[");
        sb.append(getKuvitus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kartat</column-name><column-value><![CDATA[");
        sb.append(getKartat());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>liitteita</column-name><column-value><![CDATA[");
        sb.append(getLiitteita());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>nimikirj</column-name><column-value><![CDATA[");
        sb.append(getNimikirj());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sinetti</column-name><column-value><![CDATA[");
        sb.append(getSinetti());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>leima</column-name><column-value><![CDATA[");
        sb.append(getLeima());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>exlibris</column-name><column-value><![CDATA[");
        sb.append(getExlibris());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>hintamerk</column-name><column-value><![CDATA[");
        sb.append(getHintamerk());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>omiste</column-name><column-value><![CDATA[");
        sb.append(getOmiste());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>reunamerk</column-name><column-value><![CDATA[");
        sb.append(getReunamerk());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lisatieto</column-name><column-value><![CDATA[");
        sb.append(getLisatieto());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lahosoite</column-name><column-value><![CDATA[");
        sb.append(getLahosoite());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lahemail</column-name><column-value><![CDATA[");
        sb.append(getLahemail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kieliid</column-name><column-value><![CDATA[");
        sb.append(getKieliid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kielestaid</column-name><column-value><![CDATA[");
        sb.append(getKielestaid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>julklajiid</column-name><column-value><![CDATA[");
        sb.append(getJulklajiid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kuntoid</column-name><column-value><![CDATA[");
        sb.append(getKuntoid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>puuteid</column-name><column-value><![CDATA[");
        sb.append(getPuuteid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>teospkid</column-name><column-value><![CDATA[");
        sb.append(getTeospkid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sidonta</column-name><column-value><![CDATA[");
        sb.append(getSidonta());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>kokoelma</column-name><column-value><![CDATA[");
        sb.append(getKokoelma());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>poistettu</column-name><column-value><![CDATA[");
        sb.append(getPoistettu());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>muokattu</column-name><column-value><![CDATA[");
        sb.append(getMuokattu());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
