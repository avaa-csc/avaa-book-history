package fi.csc.avaa.khl.db.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import fi.csc.avaa.khl.db.model.Maakuntainfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Maakuntainfo in entity cache.
 *
 * @author CSC
 * @see Maakuntainfo
 * @generated
 */
public class MaakuntainfoCacheModel implements CacheModel<Maakuntainfo>,
    Externalizable {
    public int maakuntaid;
    public String maakunta;
    public int kpl;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{maakuntaid=");
        sb.append(maakuntaid);
        sb.append(", maakunta=");
        sb.append(maakunta);
        sb.append(", kpl=");
        sb.append(kpl);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Maakuntainfo toEntityModel() {
        MaakuntainfoImpl maakuntainfoImpl = new MaakuntainfoImpl();

        maakuntainfoImpl.setMaakuntaid(maakuntaid);

        if (maakunta == null) {
            maakuntainfoImpl.setMaakunta(StringPool.BLANK);
        } else {
            maakuntainfoImpl.setMaakunta(maakunta);
        }

        maakuntainfoImpl.setKpl(kpl);

        maakuntainfoImpl.resetOriginalValues();

        return maakuntainfoImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        maakuntaid = objectInput.readInt();
        maakunta = objectInput.readUTF();
        kpl = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeInt(maakuntaid);

        if (maakunta == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(maakunta);
        }

        objectOutput.writeInt(kpl);
    }
}
