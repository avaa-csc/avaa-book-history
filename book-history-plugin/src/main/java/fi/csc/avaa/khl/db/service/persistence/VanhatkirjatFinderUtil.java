package fi.csc.avaa.khl.db.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;


public class VanhatkirjatFinderUtil {
    private static VanhatkirjatFinder _finder;

    public static boolean deleteAllVanhatkirjat() {
        return getFinder().deleteAllVanhatkirjat();
    }

    public static VanhatkirjatFinder getFinder() {
        if (_finder == null) {
            _finder = (VanhatkirjatFinder) PortletBeanLocatorUtil.locate(fi.csc.avaa.khl.db.service.ClpSerializer.getServletContextName(),
                    VanhatkirjatFinder.class.getName());

            ReferenceRegistry.registerReference(VanhatkirjatFinderUtil.class,
                "_finder");
        }

        return _finder;
    }

    public void setFinder(VanhatkirjatFinder finder) {
        _finder = finder;

        ReferenceRegistry.registerReference(VanhatkirjatFinderUtil.class,
            "_finder");
    }
}
