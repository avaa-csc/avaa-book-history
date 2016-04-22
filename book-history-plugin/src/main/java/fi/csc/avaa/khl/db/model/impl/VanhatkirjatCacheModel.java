package fi.csc.avaa.khl.db.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import fi.csc.avaa.khl.db.model.Vanhatkirjat;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Vanhatkirjat in entity cache.
 *
 * @author CSC
 * @see Vanhatkirjat
 * @generated
 */
public class VanhatkirjatCacheModel implements CacheModel<Vanhatkirjat>,
    Externalizable {
    public int vkid;
    public int kuntaid;
    public int maakuntaid;
    public int lomakenum;
    public long paivays;
    public int kartkohde;
    public String tekija;
    public String teoknimi;
    public int painovuosi;
    public String painopaikka;
    public String kirjapaino;
    public int painosmerk;
    public int imprimatur;
    public int kuvitus;
    public int kartat;
    public int liitteita;
    public String nimikirj;
    public int sinetti;
    public int leima;
    public int exlibris;
    public int hintamerk;
    public String omiste;
    public String reunamerk;
    public String lisatieto;
    public String lahosoite;
    public String lahemail;
    public int status;
    public int kieliid;
    public int kielestaid;
    public int julklajiid;
    public int kuntoid;
    public int puuteid;
    public int teospkid;
    public int sidonta;
    public String kokoelma;
    public long poistettu;
    public long muokattu;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(75);

        sb.append("{vkid=");
        sb.append(vkid);
        sb.append(", kuntaid=");
        sb.append(kuntaid);
        sb.append(", maakuntaid=");
        sb.append(maakuntaid);
        sb.append(", lomakenum=");
        sb.append(lomakenum);
        sb.append(", paivays=");
        sb.append(paivays);
        sb.append(", kartkohde=");
        sb.append(kartkohde);
        sb.append(", tekija=");
        sb.append(tekija);
        sb.append(", teoknimi=");
        sb.append(teoknimi);
        sb.append(", painovuosi=");
        sb.append(painovuosi);
        sb.append(", painopaikka=");
        sb.append(painopaikka);
        sb.append(", kirjapaino=");
        sb.append(kirjapaino);
        sb.append(", painosmerk=");
        sb.append(painosmerk);
        sb.append(", imprimatur=");
        sb.append(imprimatur);
        sb.append(", kuvitus=");
        sb.append(kuvitus);
        sb.append(", kartat=");
        sb.append(kartat);
        sb.append(", liitteita=");
        sb.append(liitteita);
        sb.append(", nimikirj=");
        sb.append(nimikirj);
        sb.append(", sinetti=");
        sb.append(sinetti);
        sb.append(", leima=");
        sb.append(leima);
        sb.append(", exlibris=");
        sb.append(exlibris);
        sb.append(", hintamerk=");
        sb.append(hintamerk);
        sb.append(", omiste=");
        sb.append(omiste);
        sb.append(", reunamerk=");
        sb.append(reunamerk);
        sb.append(", lisatieto=");
        sb.append(lisatieto);
        sb.append(", lahosoite=");
        sb.append(lahosoite);
        sb.append(", lahemail=");
        sb.append(lahemail);
        sb.append(", status=");
        sb.append(status);
        sb.append(", kieliid=");
        sb.append(kieliid);
        sb.append(", kielestaid=");
        sb.append(kielestaid);
        sb.append(", julklajiid=");
        sb.append(julklajiid);
        sb.append(", kuntoid=");
        sb.append(kuntoid);
        sb.append(", puuteid=");
        sb.append(puuteid);
        sb.append(", teospkid=");
        sb.append(teospkid);
        sb.append(", sidonta=");
        sb.append(sidonta);
        sb.append(", kokoelma=");
        sb.append(kokoelma);
        sb.append(", poistettu=");
        sb.append(poistettu);
        sb.append(", muokattu=");
        sb.append(muokattu);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Vanhatkirjat toEntityModel() {
        VanhatkirjatImpl vanhatkirjatImpl = new VanhatkirjatImpl();

        vanhatkirjatImpl.setVkid(vkid);
        vanhatkirjatImpl.setKuntaid(kuntaid);
        vanhatkirjatImpl.setMaakuntaid(maakuntaid);
        vanhatkirjatImpl.setLomakenum(lomakenum);

        if (paivays == Long.MIN_VALUE) {
            vanhatkirjatImpl.setPaivays(null);
        } else {
            vanhatkirjatImpl.setPaivays(new Date(paivays));
        }

        vanhatkirjatImpl.setKartkohde(kartkohde);

        if (tekija == null) {
            vanhatkirjatImpl.setTekija(StringPool.BLANK);
        } else {
            vanhatkirjatImpl.setTekija(tekija);
        }

        if (teoknimi == null) {
            vanhatkirjatImpl.setTeoknimi(StringPool.BLANK);
        } else {
            vanhatkirjatImpl.setTeoknimi(teoknimi);
        }

        vanhatkirjatImpl.setPainovuosi(painovuosi);

        if (painopaikka == null) {
            vanhatkirjatImpl.setPainopaikka(StringPool.BLANK);
        } else {
            vanhatkirjatImpl.setPainopaikka(painopaikka);
        }

        if (kirjapaino == null) {
            vanhatkirjatImpl.setKirjapaino(StringPool.BLANK);
        } else {
            vanhatkirjatImpl.setKirjapaino(kirjapaino);
        }

        vanhatkirjatImpl.setPainosmerk(painosmerk);
        vanhatkirjatImpl.setImprimatur(imprimatur);
        vanhatkirjatImpl.setKuvitus(kuvitus);
        vanhatkirjatImpl.setKartat(kartat);
        vanhatkirjatImpl.setLiitteita(liitteita);

        if (nimikirj == null) {
            vanhatkirjatImpl.setNimikirj(StringPool.BLANK);
        } else {
            vanhatkirjatImpl.setNimikirj(nimikirj);
        }

        vanhatkirjatImpl.setSinetti(sinetti);
        vanhatkirjatImpl.setLeima(leima);
        vanhatkirjatImpl.setExlibris(exlibris);
        vanhatkirjatImpl.setHintamerk(hintamerk);

        if (omiste == null) {
            vanhatkirjatImpl.setOmiste(StringPool.BLANK);
        } else {
            vanhatkirjatImpl.setOmiste(omiste);
        }

        if (reunamerk == null) {
            vanhatkirjatImpl.setReunamerk(StringPool.BLANK);
        } else {
            vanhatkirjatImpl.setReunamerk(reunamerk);
        }

        if (lisatieto == null) {
            vanhatkirjatImpl.setLisatieto(StringPool.BLANK);
        } else {
            vanhatkirjatImpl.setLisatieto(lisatieto);
        }

        if (lahosoite == null) {
            vanhatkirjatImpl.setLahosoite(StringPool.BLANK);
        } else {
            vanhatkirjatImpl.setLahosoite(lahosoite);
        }

        if (lahemail == null) {
            vanhatkirjatImpl.setLahemail(StringPool.BLANK);
        } else {
            vanhatkirjatImpl.setLahemail(lahemail);
        }

        vanhatkirjatImpl.setStatus(status);
        vanhatkirjatImpl.setKieliid(kieliid);
        vanhatkirjatImpl.setKielestaid(kielestaid);
        vanhatkirjatImpl.setJulklajiid(julklajiid);
        vanhatkirjatImpl.setKuntoid(kuntoid);
        vanhatkirjatImpl.setPuuteid(puuteid);
        vanhatkirjatImpl.setTeospkid(teospkid);
        vanhatkirjatImpl.setSidonta(sidonta);

        if (kokoelma == null) {
            vanhatkirjatImpl.setKokoelma(StringPool.BLANK);
        } else {
            vanhatkirjatImpl.setKokoelma(kokoelma);
        }

        if (poistettu == Long.MIN_VALUE) {
            vanhatkirjatImpl.setPoistettu(null);
        } else {
            vanhatkirjatImpl.setPoistettu(new Date(poistettu));
        }

        if (muokattu == Long.MIN_VALUE) {
            vanhatkirjatImpl.setMuokattu(null);
        } else {
            vanhatkirjatImpl.setMuokattu(new Date(muokattu));
        }

        vanhatkirjatImpl.resetOriginalValues();

        return vanhatkirjatImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        vkid = objectInput.readInt();
        kuntaid = objectInput.readInt();
        maakuntaid = objectInput.readInt();
        lomakenum = objectInput.readInt();
        paivays = objectInput.readLong();
        kartkohde = objectInput.readInt();
        tekija = objectInput.readUTF();
        teoknimi = objectInput.readUTF();
        painovuosi = objectInput.readInt();
        painopaikka = objectInput.readUTF();
        kirjapaino = objectInput.readUTF();
        painosmerk = objectInput.readInt();
        imprimatur = objectInput.readInt();
        kuvitus = objectInput.readInt();
        kartat = objectInput.readInt();
        liitteita = objectInput.readInt();
        nimikirj = objectInput.readUTF();
        sinetti = objectInput.readInt();
        leima = objectInput.readInt();
        exlibris = objectInput.readInt();
        hintamerk = objectInput.readInt();
        omiste = objectInput.readUTF();
        reunamerk = objectInput.readUTF();
        lisatieto = objectInput.readUTF();
        lahosoite = objectInput.readUTF();
        lahemail = objectInput.readUTF();
        status = objectInput.readInt();
        kieliid = objectInput.readInt();
        kielestaid = objectInput.readInt();
        julklajiid = objectInput.readInt();
        kuntoid = objectInput.readInt();
        puuteid = objectInput.readInt();
        teospkid = objectInput.readInt();
        sidonta = objectInput.readInt();
        kokoelma = objectInput.readUTF();
        poistettu = objectInput.readLong();
        muokattu = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeInt(vkid);
        objectOutput.writeInt(kuntaid);
        objectOutput.writeInt(maakuntaid);
        objectOutput.writeInt(lomakenum);
        objectOutput.writeLong(paivays);
        objectOutput.writeInt(kartkohde);

        if (tekija == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(tekija);
        }

        if (teoknimi == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(teoknimi);
        }

        objectOutput.writeInt(painovuosi);

        if (painopaikka == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(painopaikka);
        }

        if (kirjapaino == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(kirjapaino);
        }

        objectOutput.writeInt(painosmerk);
        objectOutput.writeInt(imprimatur);
        objectOutput.writeInt(kuvitus);
        objectOutput.writeInt(kartat);
        objectOutput.writeInt(liitteita);

        if (nimikirj == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(nimikirj);
        }

        objectOutput.writeInt(sinetti);
        objectOutput.writeInt(leima);
        objectOutput.writeInt(exlibris);
        objectOutput.writeInt(hintamerk);

        if (omiste == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(omiste);
        }

        if (reunamerk == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(reunamerk);
        }

        if (lisatieto == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(lisatieto);
        }

        if (lahosoite == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(lahosoite);
        }

        if (lahemail == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(lahemail);
        }

        objectOutput.writeInt(status);
        objectOutput.writeInt(kieliid);
        objectOutput.writeInt(kielestaid);
        objectOutput.writeInt(julklajiid);
        objectOutput.writeInt(kuntoid);
        objectOutput.writeInt(puuteid);
        objectOutput.writeInt(teospkid);
        objectOutput.writeInt(sidonta);

        if (kokoelma == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(kokoelma);
        }

        objectOutput.writeLong(poistettu);
        objectOutput.writeLong(muokattu);
    }
}
