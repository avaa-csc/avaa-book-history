package fi.csc.avaa.khl.db.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import fi.csc.avaa.khl.db.model.Kuntoluokitus;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Kuntoluokitus in entity cache.
 *
 * @author CSC
 * @see Kuntoluokitus
 * @generated
 */
public class KuntoluokitusCacheModel implements CacheModel<Kuntoluokitus>,
    Externalizable {
    public int kuntoid;
    public String kunto;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{kuntoid=");
        sb.append(kuntoid);
        sb.append(", kunto=");
        sb.append(kunto);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Kuntoluokitus toEntityModel() {
        KuntoluokitusImpl kuntoluokitusImpl = new KuntoluokitusImpl();

        kuntoluokitusImpl.setKuntoid(kuntoid);

        if (kunto == null) {
            kuntoluokitusImpl.setKunto(StringPool.BLANK);
        } else {
            kuntoluokitusImpl.setKunto(kunto);
        }

        kuntoluokitusImpl.resetOriginalValues();

        return kuntoluokitusImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        kuntoid = objectInput.readInt();
        kunto = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeInt(kuntoid);

        if (kunto == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(kunto);
        }
    }
}
