package fi.csc.avaa.khl.db.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import fi.csc.avaa.khl.db.service.ClpSerializer;
import fi.csc.avaa.khl.db.service.JulkaisulajiinfoLocalServiceUtil;
import fi.csc.avaa.khl.db.service.JulkaisulajiinfoServiceUtil;
import fi.csc.avaa.khl.db.service.KartoituskohdeLocalServiceUtil;
import fi.csc.avaa.khl.db.service.KartoituskohdeServiceUtil;
import fi.csc.avaa.khl.db.service.KielestaLocalServiceUtil;
import fi.csc.avaa.khl.db.service.KielestaServiceUtil;
import fi.csc.avaa.khl.db.service.KieliinfoLocalServiceUtil;
import fi.csc.avaa.khl.db.service.KieliinfoServiceUtil;
import fi.csc.avaa.khl.db.service.KuntainfoLocalServiceUtil;
import fi.csc.avaa.khl.db.service.KuntainfoServiceUtil;
import fi.csc.avaa.khl.db.service.KuntoluokitusLocalServiceUtil;
import fi.csc.avaa.khl.db.service.KuntoluokitusServiceUtil;
import fi.csc.avaa.khl.db.service.MaakuntainfoLocalServiceUtil;
import fi.csc.avaa.khl.db.service.MaakuntainfoServiceUtil;
import fi.csc.avaa.khl.db.service.PuuteLocalServiceUtil;
import fi.csc.avaa.khl.db.service.PuuteServiceUtil;
import fi.csc.avaa.khl.db.service.SidottuLocalServiceUtil;
import fi.csc.avaa.khl.db.service.SidottuServiceUtil;
import fi.csc.avaa.khl.db.service.TeospkLocalServiceUtil;
import fi.csc.avaa.khl.db.service.TeospkServiceUtil;
import fi.csc.avaa.khl.db.service.VanhatkirjatLocalServiceUtil;
import fi.csc.avaa.khl.db.service.VanhatkirjatServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            JulkaisulajiinfoLocalServiceUtil.clearService();

            JulkaisulajiinfoServiceUtil.clearService();
            KartoituskohdeLocalServiceUtil.clearService();

            KartoituskohdeServiceUtil.clearService();
            KielestaLocalServiceUtil.clearService();

            KielestaServiceUtil.clearService();
            KieliinfoLocalServiceUtil.clearService();

            KieliinfoServiceUtil.clearService();
            KuntainfoLocalServiceUtil.clearService();

            KuntainfoServiceUtil.clearService();
            KuntoluokitusLocalServiceUtil.clearService();

            KuntoluokitusServiceUtil.clearService();
            MaakuntainfoLocalServiceUtil.clearService();

            MaakuntainfoServiceUtil.clearService();
            PuuteLocalServiceUtil.clearService();

            PuuteServiceUtil.clearService();
            SidottuLocalServiceUtil.clearService();

            SidottuServiceUtil.clearService();
            TeospkLocalServiceUtil.clearService();

            TeospkServiceUtil.clearService();
            VanhatkirjatLocalServiceUtil.clearService();

            VanhatkirjatServiceUtil.clearService();
        }
    }
}
