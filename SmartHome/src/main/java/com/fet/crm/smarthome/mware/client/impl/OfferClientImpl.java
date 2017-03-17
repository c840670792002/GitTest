package com.fet.crm.smarthome.mware.client.impl;

import com.fet.crm.smarthome.generic.bean.OfferVO;
import com.fet.crm.smarthome.generic.util.JAXBObjectFactoryUtils;
import com.fet.crm.smarthome.generic.util.MessageUtil;
import com.fet.crm.smarthome.mware.client.OfferClient;
import com.fet.esb.crm.biz.services.crmbillinquirybizservice.CRMBillInquiryBizService;
import com.fet.generic.logger.ILogger;
import com.fet.generic.logger.LoggerFactory;
import com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema.ArrayOfOfferInfo;
import com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema.BusinessEntityInfo;
import com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema.InstantOfferCriteria;
import com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema.OfferInfo;
import com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema.ParameterInfo;
import com.tibco.schemas.crm_billing.sharedresources.xsd.base.imported.schema.SubscriberNoInfo;
import com.tibco.schemas.crm_billingbizservices.sharedresources.xsd.schema.QueryOfferListRequest;
import com.tibco.schemas.crm_billingbizservices.sharedresources.xsd.schema.QueryOfferListResponse;
import com.tibco.schemas.crm_billingbizservices.sharedresources.xsd.schema.TransactionInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import tw.com.fet.itsoa.schemas.common_domain.sharedresources.xsd.base.schema.AuthInfo;

/**
 * 呼叫 bus CMOffer 之 client
 * 
 * @author Paul Chan
 * @version 1.0.0.0
 */
public class OfferClientImpl implements OfferClient {
    private static final ILogger LOG = LoggerFactory.getLogger(OfferClientImpl.class);
    private static final Comparator<OfferVO> COMPARATOR;
    private transient CRMBillInquiryBizService crmBillInquiryBizService;

    static {
        COMPARATOR = new Comparator<OfferVO>() {

            @Override
            public int compare(OfferVO o1, OfferVO o2) {
                int result = 0;
                // FETT0000020FHDEKHC
                if (null != o1 && null != o2 && null != o1.getDeviceSerial() && null != o2.getDeviceSerial()) {
                    final String tmpDID1 = o1.getDeviceSerial().substring(4, 11);
                    final String tmpDID2 = o2.getDeviceSerial().substring(4, 11);
                    result = tmpDID2.compareTo(tmpDID1);
                }
                return result;
            }
        };
    }

    /**
     * DOCUMENT ME!
     * 
     * @param crmBillInquiryBizService
     *            DOCUMENT ME!
     */
    public void setCrmBillInquiryBizService(final CRMBillInquiryBizService crmBillInquiryBizService) {
        this.crmBillInquiryBizService = crmBillInquiryBizService;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param subscriberId
     *            DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public List<OfferVO> queryOfferList(final String subscriberId) {
        LOG.info("CRM-BillingInquiryBizService url : " + MessageUtil.getStringMessage("esb.service.url"));
        // prepare cm offer request
        final QueryOfferListRequest request = new QueryOfferListRequest();

        // authInfo
        final AuthInfo authInfo = JAXBObjectFactoryUtils.getCommonObjectFactory().createAuthInfo();
        authInfo.setUserID(MessageUtil.getStringMessage("auth_info.user_id"));
        authInfo.setPassword(MessageUtil.getStringMessage("auth_info.password"));
        authInfo.setChannelID(MessageUtil.getStringMessage("auth_info.channel_id"));
        request.setAuthInfo(authInfo);

        TransactionInfo transactionInfo = JAXBObjectFactoryUtils.getBillingServiceObjectFactory()
                .createTransactionInfo();
        transactionInfo.setTransChannelId(MessageUtil.getStringMessage("transInfo.trans_channel_id"));
        transactionInfo.setTransSubChannel(JAXBObjectFactoryUtils.getBillingServiceObjectFactory().createTransactionInfoTransSubChannel(MessageUtil.getStringMessage("transInfo.trans_sub_channel")));
        transactionInfo.setTransUserId(MessageUtil.getStringMessage("transInfo.trans_user_id"));
        transactionInfo.setTransBpId(MessageUtil.getStringMessage("transInfo.trans_bp_id"));
        transactionInfo.setTransPath(MessageUtil.getStringMessage("transInfo.trans_path"));
        request.setTransInfo(transactionInfo);

        // instantOfferCriteria
        final InstantOfferCriteria instantOfferCriteria = JAXBObjectFactoryUtils.getBillingObjectFactory()
                .createInstantOfferCriteria();
        final SubscriberNoInfo subscriberInfo = JAXBObjectFactoryUtils.getBillingObjectFactory()
                .createSubscriberNoInfo();
        subscriberInfo.setSubscriberNumber(JAXBObjectFactoryUtils.getBillingObjectFactory()
                .createSubscriberNoInfoSubscriberNumber(subscriberId));
        instantOfferCriteria.setSubscriberNo(JAXBObjectFactoryUtils.getBillingObjectFactory()
                .createInstantOfferCriteriaSubscriberNo(subscriberInfo));
        request.setQueryCriteria(instantOfferCriteria);

        // beInfo
        final BusinessEntityInfo beInfo = JAXBObjectFactoryUtils.getBillingObjectFactory().createBusinessEntityInfo();
        beInfo.setBusinessEntityNumber(JAXBObjectFactoryUtils.getBillingObjectFactory()
                .createBusinessEntityInfoBusinessEntityNumber(MessageUtil.getInteger("query_offer_list.be_no")));
        beInfo.setPaymentCategory(JAXBObjectFactoryUtils.getBillingObjectFactory()
                .createBusinessEntityInfoPaymentCategory(
                        MessageUtil.getStringMessage("query_offer_list.payment_category")));
        request.setBeInfo(beInfo);

        // call bus : cm offer queryOfferList
        final QueryOfferListResponse response = crmBillInquiryBizService.queryOfferList(request);

        final String returnMsg = response.getReturnHeader().getReturnMesg();

        final List<OfferVO> result = new ArrayList<OfferVO>();

        // “SUCCESS” 代表成功，其他代表失敗。
        if ("SUCCESS".equalsIgnoreCase(returnMsg)) {
            final StringBuffer offerNameKey = new StringBuffer();
            final ArrayOfOfferInfo offerList = response.getQueryOfferResult().getOfferList().getValue();

            for (final OfferInfo offerInfo : offerList.getOfferInfo()) {
                final List<ParameterInfo> parameterList = offerInfo.getParameterList().getValue().getParameterInfo();

                for (final ParameterInfo parameterInfo : parameterList) {
                    // 特定Parameter Name 才會是紀錄設備編號的參數。 例如：UID_A, UID_B, UID_C
                    // 讀取 smarthome.properties 設定檔
                    // query_offer_list.valid_param_names，以逗號隔開
                    final List<String> paramNames = MessageUtil.getArrayMessage("query_offer_list.valid_param_names");
                    final String paramName = parameterInfo.getParameterName().getValue();

                    if (paramNames.contains(paramName)) {
                        final List<String> parameterValues = parameterInfo.getParameterValues().getValue().getString();

                        if (parameterValues.isEmpty()) {
                            LOG.info("parameterValues is empty");
                        } else {
                            final OfferVO offerVO = new OfferVO();

                            // 取得的Offer Code 需對應設定檔，顯示方案名稱於畫面上。
                            final String offerCode = offerInfo.getOfferCode().getValue();
                            offerVO.setOfferCode(offerCode);

                            offerNameKey.delete(0, offerNameKey.length());
                            offerNameKey.append("offer_name.");
                            offerNameKey.append(offerCode);

                            // TODO 如果對應設定檔找不到的話暫定擺入 Billing System 的服務名稱，待確認。
                            final String offerName = MessageUtil.getStringMessage(offerNameKey.toString(), offerInfo
                                    .getOfferName().getValue());
                            offerVO.setOfferName(offerName);
                            // 取陣列的第一個值。此值代表設備編號。可用來查詢設備API 使用。
                            offerVO.setDeviceSerial(parameterValues.get(0));
                            result.add(offerVO);
                        }
                    }
                }
            }
        } else {
            LOG.info("call cm offer fail");
        }
        Collections.sort(result, COMPARATOR);
        return result;
    }
}
