package fi.csc.avaa.khl.db.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import fi.csc.avaa.khl.db.model.Kartoituskohde;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Kartoituskohde in entity cache.
 *
 * @author CSC
 * @see Kartoituskohde
 * @generated
 */
public class KartoituskohdeCacheModel implements CacheModel<Kartoituskohde>,
    Externalizable {
    public int kohdeid;
    public String kartkohde;
    public int kpl;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{kohdeid=");
        sb.append(kohdeid);
        sb.append(", kartkohde=");
        sb.append(kartkohde);
        sb.append(", kpl=");
        sb.append(kpl);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Kartoituskohde toEntityModel() {
        KartoituskohdeImpl kartoituskohdeImpl = new KartoituskohdeImpl();

        kartoituskohdeImpl.setKohdeid(kohdeid);

        if (kartkohde == null) {
            kartoituskohdeImpl.setKartkohde(StringPool.BLANK);
        } else {
            kartoituskohdeImpl.setKartkohde(kartkohde);
        }

        kartoituskohdeImpl.setKpl(kpl);

        kartoituskohdeImpl.resetOriginalValues();

        return kartoituskohdeImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        kohdeid = objectInput.readInt();
        kartkohde = objectInput.readUTF();
        kpl = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeInt(kohdeid);

        if (kartkohde == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(kartkohde);
        }

        objectOutput.writeInt(kpl);
    }
}
