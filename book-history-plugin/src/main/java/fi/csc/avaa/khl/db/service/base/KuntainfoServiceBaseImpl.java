package fi.csc.avaa.khl.db.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import fi.csc.avaa.khl.db.model.Kuntainfo;
import fi.csc.avaa.khl.db.service.KuntainfoService;
import fi.csc.avaa.khl.db.service.persistence.BookHistoryAPIPersistence;
import fi.csc.avaa.khl.db.service.persistence.JulkaisulajiinfoPersistence;
import fi.csc.avaa.khl.db.service.persistence.KartoituskohdePersistence;
import fi.csc.avaa.khl.db.service.persistence.KielestaPersistence;
import fi.csc.avaa.khl.db.service.persistence.KieliinfoPersistence;
import fi.csc.avaa.khl.db.service.persistence.KuntainfoPersistence;
import fi.csc.avaa.khl.db.service.persistence.KuntoluokitusPersistence;
import fi.csc.avaa.khl.db.service.persistence.MaakuntainfoPersistence;
import fi.csc.avaa.khl.db.service.persistence.PuutePersistence;
import fi.csc.avaa.khl.db.service.persistence.SidottuPersistence;
import fi.csc.avaa.khl.db.service.persistence.TeospkPersistence;
import fi.csc.avaa.khl.db.service.persistence.VanhatkirjatFinder;
import fi.csc.avaa.khl.db.service.persistence.VanhatkirjatPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the kuntainfo remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link fi.csc.avaa.khl.db.service.impl.KuntainfoServiceImpl}.
 * </p>
 *
 * @author CSC
 * @see fi.csc.avaa.khl.db.service.impl.KuntainfoServiceImpl
 * @see fi.csc.avaa.khl.db.service.KuntainfoServiceUtil
 * @generated
 */
public abstract class KuntainfoServiceBaseImpl extends BaseServiceImpl
    implements KuntainfoService, IdentifiableBean {
    @BeanReference(type = fi.csc.avaa.khl.db.service.BookHistoryAPIService.class)
    protected fi.csc.avaa.khl.db.service.BookHistoryAPIService bookHistoryAPIService;
    @BeanReference(type = BookHistoryAPIPersistence.class)
    protected BookHistoryAPIPersistence bookHistoryAPIPersistence;
    @BeanReference(type = fi.csc.avaa.khl.db.service.JulkaisulajiinfoLocalService.class)
    protected fi.csc.avaa.khl.db.service.JulkaisulajiinfoLocalService julkaisulajiinfoLocalService;
    @BeanReference(type = fi.csc.avaa.khl.db.service.JulkaisulajiinfoService.class)
    protected fi.csc.avaa.khl.db.service.JulkaisulajiinfoService julkaisulajiinfoService;
    @BeanReference(type = JulkaisulajiinfoPersistence.class)
    protected JulkaisulajiinfoPersistence julkaisulajiinfoPersistence;
    @BeanReference(type = fi.csc.avaa.khl.db.service.KartoituskohdeLocalService.class)
    protected fi.csc.avaa.khl.db.service.KartoituskohdeLocalService kartoituskohdeLocalService;
    @BeanReference(type = fi.csc.avaa.khl.db.service.KartoituskohdeService.class)
    protected fi.csc.avaa.khl.db.service.KartoituskohdeService kartoituskohdeService;
    @BeanReference(type = KartoituskohdePersistence.class)
    protected KartoituskohdePersistence kartoituskohdePersistence;
    @BeanReference(type = fi.csc.avaa.khl.db.service.KielestaLocalService.class)
    protected fi.csc.avaa.khl.db.service.KielestaLocalService kielestaLocalService;
    @BeanReference(type = fi.csc.avaa.khl.db.service.KielestaService.class)
    protected fi.csc.avaa.khl.db.service.KielestaService kielestaService;
    @BeanReference(type = KielestaPersistence.class)
    protected KielestaPersistence kielestaPersistence;
    @BeanReference(type = fi.csc.avaa.khl.db.service.KieliinfoLocalService.class)
    protected fi.csc.avaa.khl.db.service.KieliinfoLocalService kieliinfoLocalService;
    @BeanReference(type = fi.csc.avaa.khl.db.service.KieliinfoService.class)
    protected fi.csc.avaa.khl.db.service.KieliinfoService kieliinfoService;
    @BeanReference(type = KieliinfoPersistence.class)
    protected KieliinfoPersistence kieliinfoPersistence;
    @BeanReference(type = fi.csc.avaa.khl.db.service.KuntainfoLocalService.class)
    protected fi.csc.avaa.khl.db.service.KuntainfoLocalService kuntainfoLocalService;
    @BeanReference(type = fi.csc.avaa.khl.db.service.KuntainfoService.class)
    protected fi.csc.avaa.khl.db.service.KuntainfoService kuntainfoService;
    @BeanReference(type = KuntainfoPersistence.class)
    protected KuntainfoPersistence kuntainfoPersistence;
    @BeanReference(type = fi.csc.avaa.khl.db.service.KuntoluokitusLocalService.class)
    protected fi.csc.avaa.khl.db.service.KuntoluokitusLocalService kuntoluokitusLocalService;
    @BeanReference(type = fi.csc.avaa.khl.db.service.KuntoluokitusService.class)
    protected fi.csc.avaa.khl.db.service.KuntoluokitusService kuntoluokitusService;
    @BeanReference(type = KuntoluokitusPersistence.class)
    protected KuntoluokitusPersistence kuntoluokitusPersistence;
    @BeanReference(type = fi.csc.avaa.khl.db.service.MaakuntainfoLocalService.class)
    protected fi.csc.avaa.khl.db.service.MaakuntainfoLocalService maakuntainfoLocalService;
    @BeanReference(type = fi.csc.avaa.khl.db.service.MaakuntainfoService.class)
    protected fi.csc.avaa.khl.db.service.MaakuntainfoService maakuntainfoService;
    @BeanReference(type = MaakuntainfoPersistence.class)
    protected MaakuntainfoPersistence maakuntainfoPersistence;
    @BeanReference(type = fi.csc.avaa.khl.db.service.PuuteLocalService.class)
    protected fi.csc.avaa.khl.db.service.PuuteLocalService puuteLocalService;
    @BeanReference(type = fi.csc.avaa.khl.db.service.PuuteService.class)
    protected fi.csc.avaa.khl.db.service.PuuteService puuteService;
    @BeanReference(type = PuutePersistence.class)
    protected PuutePersistence puutePersistence;
    @BeanReference(type = fi.csc.avaa.khl.db.service.SidottuLocalService.class)
    protected fi.csc.avaa.khl.db.service.SidottuLocalService sidottuLocalService;
    @BeanReference(type = fi.csc.avaa.khl.db.service.SidottuService.class)
    protected fi.csc.avaa.khl.db.service.SidottuService sidottuService;
    @BeanReference(type = SidottuPersistence.class)
    protected SidottuPersistence sidottuPersistence;
    @BeanReference(type = fi.csc.avaa.khl.db.service.TeospkLocalService.class)
    protected fi.csc.avaa.khl.db.service.TeospkLocalService teospkLocalService;
    @BeanReference(type = fi.csc.avaa.khl.db.service.TeospkService.class)
    protected fi.csc.avaa.khl.db.service.TeospkService teospkService;
    @BeanReference(type = TeospkPersistence.class)
    protected TeospkPersistence teospkPersistence;
    @BeanReference(type = fi.csc.avaa.khl.db.service.VanhatkirjatLocalService.class)
    protected fi.csc.avaa.khl.db.service.VanhatkirjatLocalService vanhatkirjatLocalService;
    @BeanReference(type = fi.csc.avaa.khl.db.service.VanhatkirjatService.class)
    protected fi.csc.avaa.khl.db.service.VanhatkirjatService vanhatkirjatService;
    @BeanReference(type = VanhatkirjatPersistence.class)
    protected VanhatkirjatPersistence vanhatkirjatPersistence;
    @BeanReference(type = VanhatkirjatFinder.class)
    protected VanhatkirjatFinder vanhatkirjatFinder;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private KuntainfoServiceClpInvoker _clpInvoker = new KuntainfoServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link fi.csc.avaa.khl.db.service.KuntainfoServiceUtil} to access the kuntainfo remote service.
     */

    /**
     * Returns the book history a p i remote service.
     *
     * @return the book history a p i remote service
     */
    public fi.csc.avaa.khl.db.service.BookHistoryAPIService getBookHistoryAPIService() {
        return bookHistoryAPIService;
    }

    /**
     * Sets the book history a p i remote service.
     *
     * @param bookHistoryAPIService the book history a p i remote service
     */
    public void setBookHistoryAPIService(
        fi.csc.avaa.khl.db.service.BookHistoryAPIService bookHistoryAPIService) {
        this.bookHistoryAPIService = bookHistoryAPIService;
    }

    /**
     * Returns the book history a p i persistence.
     *
     * @return the book history a p i persistence
     */
    public BookHistoryAPIPersistence getBookHistoryAPIPersistence() {
        return bookHistoryAPIPersistence;
    }

    /**
     * Sets the book history a p i persistence.
     *
     * @param bookHistoryAPIPersistence the book history a p i persistence
     */
    public void setBookHistoryAPIPersistence(
        BookHistoryAPIPersistence bookHistoryAPIPersistence) {
        this.bookHistoryAPIPersistence = bookHistoryAPIPersistence;
    }

    /**
     * Returns the julkaisulajiinfo local service.
     *
     * @return the julkaisulajiinfo local service
     */
    public fi.csc.avaa.khl.db.service.JulkaisulajiinfoLocalService getJulkaisulajiinfoLocalService() {
        return julkaisulajiinfoLocalService;
    }

    /**
     * Sets the julkaisulajiinfo local service.
     *
     * @param julkaisulajiinfoLocalService the julkaisulajiinfo local service
     */
    public void setJulkaisulajiinfoLocalService(
        fi.csc.avaa.khl.db.service.JulkaisulajiinfoLocalService julkaisulajiinfoLocalService) {
        this.julkaisulajiinfoLocalService = julkaisulajiinfoLocalService;
    }

    /**
     * Returns the julkaisulajiinfo remote service.
     *
     * @return the julkaisulajiinfo remote service
     */
    public fi.csc.avaa.khl.db.service.JulkaisulajiinfoService getJulkaisulajiinfoService() {
        return julkaisulajiinfoService;
    }

    /**
     * Sets the julkaisulajiinfo remote service.
     *
     * @param julkaisulajiinfoService the julkaisulajiinfo remote service
     */
    public void setJulkaisulajiinfoService(
        fi.csc.avaa.khl.db.service.JulkaisulajiinfoService julkaisulajiinfoService) {
        this.julkaisulajiinfoService = julkaisulajiinfoService;
    }

    /**
     * Returns the julkaisulajiinfo persistence.
     *
     * @return the julkaisulajiinfo persistence
     */
    public JulkaisulajiinfoPersistence getJulkaisulajiinfoPersistence() {
        return julkaisulajiinfoPersistence;
    }

    /**
     * Sets the julkaisulajiinfo persistence.
     *
     * @param julkaisulajiinfoPersistence the julkaisulajiinfo persistence
     */
    public void setJulkaisulajiinfoPersistence(
        JulkaisulajiinfoPersistence julkaisulajiinfoPersistence) {
        this.julkaisulajiinfoPersistence = julkaisulajiinfoPersistence;
    }

    /**
     * Returns the kartoituskohde local service.
     *
     * @return the kartoituskohde local service
     */
    public fi.csc.avaa.khl.db.service.KartoituskohdeLocalService getKartoituskohdeLocalService() {
        return kartoituskohdeLocalService;
    }

    /**
     * Sets the kartoituskohde local service.
     *
     * @param kartoituskohdeLocalService the kartoituskohde local service
     */
    public void setKartoituskohdeLocalService(
        fi.csc.avaa.khl.db.service.KartoituskohdeLocalService kartoituskohdeLocalService) {
        this.kartoituskohdeLocalService = kartoituskohdeLocalService;
    }

    /**
     * Returns the kartoituskohde remote service.
     *
     * @return the kartoituskohde remote service
     */
    public fi.csc.avaa.khl.db.service.KartoituskohdeService getKartoituskohdeService() {
        return kartoituskohdeService;
    }

    /**
     * Sets the kartoituskohde remote service.
     *
     * @param kartoituskohdeService the kartoituskohde remote service
     */
    public void setKartoituskohdeService(
        fi.csc.avaa.khl.db.service.KartoituskohdeService kartoituskohdeService) {
        this.kartoituskohdeService = kartoituskohdeService;
    }

    /**
     * Returns the kartoituskohde persistence.
     *
     * @return the kartoituskohde persistence
     */
    public KartoituskohdePersistence getKartoituskohdePersistence() {
        return kartoituskohdePersistence;
    }

    /**
     * Sets the kartoituskohde persistence.
     *
     * @param kartoituskohdePersistence the kartoituskohde persistence
     */
    public void setKartoituskohdePersistence(
        KartoituskohdePersistence kartoituskohdePersistence) {
        this.kartoituskohdePersistence = kartoituskohdePersistence;
    }

    /**
     * Returns the kielesta local service.
     *
     * @return the kielesta local service
     */
    public fi.csc.avaa.khl.db.service.KielestaLocalService getKielestaLocalService() {
        return kielestaLocalService;
    }

    /**
     * Sets the kielesta local service.
     *
     * @param kielestaLocalService the kielesta local service
     */
    public void setKielestaLocalService(
        fi.csc.avaa.khl.db.service.KielestaLocalService kielestaLocalService) {
        this.kielestaLocalService = kielestaLocalService;
    }

    /**
     * Returns the kielesta remote service.
     *
     * @return the kielesta remote service
     */
    public fi.csc.avaa.khl.db.service.KielestaService getKielestaService() {
        return kielestaService;
    }

    /**
     * Sets the kielesta remote service.
     *
     * @param kielestaService the kielesta remote service
     */
    public void setKielestaService(
        fi.csc.avaa.khl.db.service.KielestaService kielestaService) {
        this.kielestaService = kielestaService;
    }

    /**
     * Returns the kielesta persistence.
     *
     * @return the kielesta persistence
     */
    public KielestaPersistence getKielestaPersistence() {
        return kielestaPersistence;
    }

    /**
     * Sets the kielesta persistence.
     *
     * @param kielestaPersistence the kielesta persistence
     */
    public void setKielestaPersistence(KielestaPersistence kielestaPersistence) {
        this.kielestaPersistence = kielestaPersistence;
    }

    /**
     * Returns the kieliinfo local service.
     *
     * @return the kieliinfo local service
     */
    public fi.csc.avaa.khl.db.service.KieliinfoLocalService getKieliinfoLocalService() {
        return kieliinfoLocalService;
    }

    /**
     * Sets the kieliinfo local service.
     *
     * @param kieliinfoLocalService the kieliinfo local service
     */
    public void setKieliinfoLocalService(
        fi.csc.avaa.khl.db.service.KieliinfoLocalService kieliinfoLocalService) {
        this.kieliinfoLocalService = kieliinfoLocalService;
    }

    /**
     * Returns the kieliinfo remote service.
     *
     * @return the kieliinfo remote service
     */
    public fi.csc.avaa.khl.db.service.KieliinfoService getKieliinfoService() {
        return kieliinfoService;
    }

    /**
     * Sets the kieliinfo remote service.
     *
     * @param kieliinfoService the kieliinfo remote service
     */
    public void setKieliinfoService(
        fi.csc.avaa.khl.db.service.KieliinfoService kieliinfoService) {
        this.kieliinfoService = kieliinfoService;
    }

    /**
     * Returns the kieliinfo persistence.
     *
     * @return the kieliinfo persistence
     */
    public KieliinfoPersistence getKieliinfoPersistence() {
        return kieliinfoPersistence;
    }

    /**
     * Sets the kieliinfo persistence.
     *
     * @param kieliinfoPersistence the kieliinfo persistence
     */
    public void setKieliinfoPersistence(
        KieliinfoPersistence kieliinfoPersistence) {
        this.kieliinfoPersistence = kieliinfoPersistence;
    }

    /**
     * Returns the kuntainfo local service.
     *
     * @return the kuntainfo local service
     */
    public fi.csc.avaa.khl.db.service.KuntainfoLocalService getKuntainfoLocalService() {
        return kuntainfoLocalService;
    }

    /**
     * Sets the kuntainfo local service.
     *
     * @param kuntainfoLocalService the kuntainfo local service
     */
    public void setKuntainfoLocalService(
        fi.csc.avaa.khl.db.service.KuntainfoLocalService kuntainfoLocalService) {
        this.kuntainfoLocalService = kuntainfoLocalService;
    }

    /**
     * Returns the kuntainfo remote service.
     *
     * @return the kuntainfo remote service
     */
    public fi.csc.avaa.khl.db.service.KuntainfoService getKuntainfoService() {
        return kuntainfoService;
    }

    /**
     * Sets the kuntainfo remote service.
     *
     * @param kuntainfoService the kuntainfo remote service
     */
    public void setKuntainfoService(
        fi.csc.avaa.khl.db.service.KuntainfoService kuntainfoService) {
        this.kuntainfoService = kuntainfoService;
    }

    /**
     * Returns the kuntainfo persistence.
     *
     * @return the kuntainfo persistence
     */
    public KuntainfoPersistence getKuntainfoPersistence() {
        return kuntainfoPersistence;
    }

    /**
     * Sets the kuntainfo persistence.
     *
     * @param kuntainfoPersistence the kuntainfo persistence
     */
    public void setKuntainfoPersistence(
        KuntainfoPersistence kuntainfoPersistence) {
        this.kuntainfoPersistence = kuntainfoPersistence;
    }

    /**
     * Returns the kuntoluokitus local service.
     *
     * @return the kuntoluokitus local service
     */
    public fi.csc.avaa.khl.db.service.KuntoluokitusLocalService getKuntoluokitusLocalService() {
        return kuntoluokitusLocalService;
    }

    /**
     * Sets the kuntoluokitus local service.
     *
     * @param kuntoluokitusLocalService the kuntoluokitus local service
     */
    public void setKuntoluokitusLocalService(
        fi.csc.avaa.khl.db.service.KuntoluokitusLocalService kuntoluokitusLocalService) {
        this.kuntoluokitusLocalService = kuntoluokitusLocalService;
    }

    /**
     * Returns the kuntoluokitus remote service.
     *
     * @return the kuntoluokitus remote service
     */
    public fi.csc.avaa.khl.db.service.KuntoluokitusService getKuntoluokitusService() {
        return kuntoluokitusService;
    }

    /**
     * Sets the kuntoluokitus remote service.
     *
     * @param kuntoluokitusService the kuntoluokitus remote service
     */
    public void setKuntoluokitusService(
        fi.csc.avaa.khl.db.service.KuntoluokitusService kuntoluokitusService) {
        this.kuntoluokitusService = kuntoluokitusService;
    }

    /**
     * Returns the kuntoluokitus persistence.
     *
     * @return the kuntoluokitus persistence
     */
    public KuntoluokitusPersistence getKuntoluokitusPersistence() {
        return kuntoluokitusPersistence;
    }

    /**
     * Sets the kuntoluokitus persistence.
     *
     * @param kuntoluokitusPersistence the kuntoluokitus persistence
     */
    public void setKuntoluokitusPersistence(
        KuntoluokitusPersistence kuntoluokitusPersistence) {
        this.kuntoluokitusPersistence = kuntoluokitusPersistence;
    }

    /**
     * Returns the maakuntainfo local service.
     *
     * @return the maakuntainfo local service
     */
    public fi.csc.avaa.khl.db.service.MaakuntainfoLocalService getMaakuntainfoLocalService() {
        return maakuntainfoLocalService;
    }

    /**
     * Sets the maakuntainfo local service.
     *
     * @param maakuntainfoLocalService the maakuntainfo local service
     */
    public void setMaakuntainfoLocalService(
        fi.csc.avaa.khl.db.service.MaakuntainfoLocalService maakuntainfoLocalService) {
        this.maakuntainfoLocalService = maakuntainfoLocalService;
    }

    /**
     * Returns the maakuntainfo remote service.
     *
     * @return the maakuntainfo remote service
     */
    public fi.csc.avaa.khl.db.service.MaakuntainfoService getMaakuntainfoService() {
        return maakuntainfoService;
    }

    /**
     * Sets the maakuntainfo remote service.
     *
     * @param maakuntainfoService the maakuntainfo remote service
     */
    public void setMaakuntainfoService(
        fi.csc.avaa.khl.db.service.MaakuntainfoService maakuntainfoService) {
        this.maakuntainfoService = maakuntainfoService;
    }

    /**
     * Returns the maakuntainfo persistence.
     *
     * @return the maakuntainfo persistence
     */
    public MaakuntainfoPersistence getMaakuntainfoPersistence() {
        return maakuntainfoPersistence;
    }

    /**
     * Sets the maakuntainfo persistence.
     *
     * @param maakuntainfoPersistence the maakuntainfo persistence
     */
    public void setMaakuntainfoPersistence(
        MaakuntainfoPersistence maakuntainfoPersistence) {
        this.maakuntainfoPersistence = maakuntainfoPersistence;
    }

    /**
     * Returns the puute local service.
     *
     * @return the puute local service
     */
    public fi.csc.avaa.khl.db.service.PuuteLocalService getPuuteLocalService() {
        return puuteLocalService;
    }

    /**
     * Sets the puute local service.
     *
     * @param puuteLocalService the puute local service
     */
    public void setPuuteLocalService(
        fi.csc.avaa.khl.db.service.PuuteLocalService puuteLocalService) {
        this.puuteLocalService = puuteLocalService;
    }

    /**
     * Returns the puute remote service.
     *
     * @return the puute remote service
     */
    public fi.csc.avaa.khl.db.service.PuuteService getPuuteService() {
        return puuteService;
    }

    /**
     * Sets the puute remote service.
     *
     * @param puuteService the puute remote service
     */
    public void setPuuteService(
        fi.csc.avaa.khl.db.service.PuuteService puuteService) {
        this.puuteService = puuteService;
    }

    /**
     * Returns the puute persistence.
     *
     * @return the puute persistence
     */
    public PuutePersistence getPuutePersistence() {
        return puutePersistence;
    }

    /**
     * Sets the puute persistence.
     *
     * @param puutePersistence the puute persistence
     */
    public void setPuutePersistence(PuutePersistence puutePersistence) {
        this.puutePersistence = puutePersistence;
    }

    /**
     * Returns the sidottu local service.
     *
     * @return the sidottu local service
     */
    public fi.csc.avaa.khl.db.service.SidottuLocalService getSidottuLocalService() {
        return sidottuLocalService;
    }

    /**
     * Sets the sidottu local service.
     *
     * @param sidottuLocalService the sidottu local service
     */
    public void setSidottuLocalService(
        fi.csc.avaa.khl.db.service.SidottuLocalService sidottuLocalService) {
        this.sidottuLocalService = sidottuLocalService;
    }

    /**
     * Returns the sidottu remote service.
     *
     * @return the sidottu remote service
     */
    public fi.csc.avaa.khl.db.service.SidottuService getSidottuService() {
        return sidottuService;
    }

    /**
     * Sets the sidottu remote service.
     *
     * @param sidottuService the sidottu remote service
     */
    public void setSidottuService(
        fi.csc.avaa.khl.db.service.SidottuService sidottuService) {
        this.sidottuService = sidottuService;
    }

    /**
     * Returns the sidottu persistence.
     *
     * @return the sidottu persistence
     */
    public SidottuPersistence getSidottuPersistence() {
        return sidottuPersistence;
    }

    /**
     * Sets the sidottu persistence.
     *
     * @param sidottuPersistence the sidottu persistence
     */
    public void setSidottuPersistence(SidottuPersistence sidottuPersistence) {
        this.sidottuPersistence = sidottuPersistence;
    }

    /**
     * Returns the teospk local service.
     *
     * @return the teospk local service
     */
    public fi.csc.avaa.khl.db.service.TeospkLocalService getTeospkLocalService() {
        return teospkLocalService;
    }

    /**
     * Sets the teospk local service.
     *
     * @param teospkLocalService the teospk local service
     */
    public void setTeospkLocalService(
        fi.csc.avaa.khl.db.service.TeospkLocalService teospkLocalService) {
        this.teospkLocalService = teospkLocalService;
    }

    /**
     * Returns the teospk remote service.
     *
     * @return the teospk remote service
     */
    public fi.csc.avaa.khl.db.service.TeospkService getTeospkService() {
        return teospkService;
    }

    /**
     * Sets the teospk remote service.
     *
     * @param teospkService the teospk remote service
     */
    public void setTeospkService(
        fi.csc.avaa.khl.db.service.TeospkService teospkService) {
        this.teospkService = teospkService;
    }

    /**
     * Returns the teospk persistence.
     *
     * @return the teospk persistence
     */
    public TeospkPersistence getTeospkPersistence() {
        return teospkPersistence;
    }

    /**
     * Sets the teospk persistence.
     *
     * @param teospkPersistence the teospk persistence
     */
    public void setTeospkPersistence(TeospkPersistence teospkPersistence) {
        this.teospkPersistence = teospkPersistence;
    }

    /**
     * Returns the vanhatkirjat local service.
     *
     * @return the vanhatkirjat local service
     */
    public fi.csc.avaa.khl.db.service.VanhatkirjatLocalService getVanhatkirjatLocalService() {
        return vanhatkirjatLocalService;
    }

    /**
     * Sets the vanhatkirjat local service.
     *
     * @param vanhatkirjatLocalService the vanhatkirjat local service
     */
    public void setVanhatkirjatLocalService(
        fi.csc.avaa.khl.db.service.VanhatkirjatLocalService vanhatkirjatLocalService) {
        this.vanhatkirjatLocalService = vanhatkirjatLocalService;
    }

    /**
     * Returns the vanhatkirjat remote service.
     *
     * @return the vanhatkirjat remote service
     */
    public fi.csc.avaa.khl.db.service.VanhatkirjatService getVanhatkirjatService() {
        return vanhatkirjatService;
    }

    /**
     * Sets the vanhatkirjat remote service.
     *
     * @param vanhatkirjatService the vanhatkirjat remote service
     */
    public void setVanhatkirjatService(
        fi.csc.avaa.khl.db.service.VanhatkirjatService vanhatkirjatService) {
        this.vanhatkirjatService = vanhatkirjatService;
    }

    /**
     * Returns the vanhatkirjat persistence.
     *
     * @return the vanhatkirjat persistence
     */
    public VanhatkirjatPersistence getVanhatkirjatPersistence() {
        return vanhatkirjatPersistence;
    }

    /**
     * Sets the vanhatkirjat persistence.
     *
     * @param vanhatkirjatPersistence the vanhatkirjat persistence
     */
    public void setVanhatkirjatPersistence(
        VanhatkirjatPersistence vanhatkirjatPersistence) {
        this.vanhatkirjatPersistence = vanhatkirjatPersistence;
    }

    /**
     * Returns the vanhatkirjat finder.
     *
     * @return the vanhatkirjat finder
     */
    public VanhatkirjatFinder getVanhatkirjatFinder() {
        return vanhatkirjatFinder;
    }

    /**
     * Sets the vanhatkirjat finder.
     *
     * @param vanhatkirjatFinder the vanhatkirjat finder
     */
    public void setVanhatkirjatFinder(VanhatkirjatFinder vanhatkirjatFinder) {
        this.vanhatkirjatFinder = vanhatkirjatFinder;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();
    }

    public void destroy() {
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return Kuntainfo.class;
    }

    protected String getModelClassName() {
        return Kuntainfo.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = kuntainfoPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
