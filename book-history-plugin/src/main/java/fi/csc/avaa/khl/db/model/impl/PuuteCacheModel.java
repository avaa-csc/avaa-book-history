package fi.csc.avaa.khl.db.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import fi.csc.avaa.khl.db.model.Puute;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Puute in entity cache.
 *
 * @author CSC
 * @see Puute
 * @generated
 */
public class PuuteCacheModel implements CacheModel<Puute>, Externalizable {
    public int puuteid;
    public String puutenimi;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{puuteid=");
        sb.append(puuteid);
        sb.append(", puutenimi=");
        sb.append(puutenimi);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Puute toEntityModel() {
        PuuteImpl puuteImpl = new PuuteImpl();

        puuteImpl.setPuuteid(puuteid);

        if (puutenimi == null) {
            puuteImpl.setPuutenimi(StringPool.BLANK);
        } else {
            puuteImpl.setPuutenimi(puutenimi);
        }

        puuteImpl.resetOriginalValues();

        return puuteImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        puuteid = objectInput.readInt();
        puutenimi = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeInt(puuteid);

        if (puutenimi == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(puutenimi);
        }
    }
}
