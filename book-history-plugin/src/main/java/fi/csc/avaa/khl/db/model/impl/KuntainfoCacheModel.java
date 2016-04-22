package fi.csc.avaa.khl.db.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import fi.csc.avaa.khl.db.model.Kuntainfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Kuntainfo in entity cache.
 *
 * @author CSC
 * @see Kuntainfo
 * @generated
 */
public class KuntainfoCacheModel implements CacheModel<Kuntainfo>,
    Externalizable {
    public int kuntaid;
    public String capitalkuntanimi;
    public int kpl;
    public String kuntanimi;
    public int maakuntaid;
    public int kuntano;
    public String kuntanimi_2014;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{kuntaid=");
        sb.append(kuntaid);
        sb.append(", capitalkuntanimi=");
        sb.append(capitalkuntanimi);
        sb.append(", kpl=");
        sb.append(kpl);
        sb.append(", kuntanimi=");
        sb.append(kuntanimi);
        sb.append(", maakuntaid=");
        sb.append(maakuntaid);
        sb.append(", kuntano=");
        sb.append(kuntano);
        sb.append(", kuntanimi_2014=");
        sb.append(kuntanimi_2014);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Kuntainfo toEntityModel() {
        KuntainfoImpl kuntainfoImpl = new KuntainfoImpl();

        kuntainfoImpl.setKuntaid(kuntaid);

        if (capitalkuntanimi == null) {
            kuntainfoImpl.setCapitalkuntanimi(StringPool.BLANK);
        } else {
            kuntainfoImpl.setCapitalkuntanimi(capitalkuntanimi);
        }

        kuntainfoImpl.setKpl(kpl);

        if (kuntanimi == null) {
            kuntainfoImpl.setKuntanimi(StringPool.BLANK);
        } else {
            kuntainfoImpl.setKuntanimi(kuntanimi);
        }

        kuntainfoImpl.setMaakuntaid(maakuntaid);
        kuntainfoImpl.setKuntano(kuntano);

        if (kuntanimi_2014 == null) {
            kuntainfoImpl.setKuntanimi_2014(StringPool.BLANK);
        } else {
            kuntainfoImpl.setKuntanimi_2014(kuntanimi_2014);
        }

        kuntainfoImpl.resetOriginalValues();

        return kuntainfoImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        kuntaid = objectInput.readInt();
        capitalkuntanimi = objectInput.readUTF();
        kpl = objectInput.readInt();
        kuntanimi = objectInput.readUTF();
        maakuntaid = objectInput.readInt();
        kuntano = objectInput.readInt();
        kuntanimi_2014 = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeInt(kuntaid);

        if (capitalkuntanimi == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(capitalkuntanimi);
        }

        objectOutput.writeInt(kpl);

        if (kuntanimi == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(kuntanimi);
        }

        objectOutput.writeInt(maakuntaid);
        objectOutput.writeInt(kuntano);

        if (kuntanimi_2014 == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(kuntanimi_2014);
        }
    }
}
