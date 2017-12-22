package odata.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the v_stg_cs5_air_refill_ma database table.
 * 
 */
@Entity
@Table(name="stg_cs5_air_refill_ma")
@NamedQuery(name="StgCs5AirRefillMa.findAll", query="SELECT v FROM StgCs5AirRefillMa v")
public class StgCs5AirRefillMa implements Serializable {
	

	@Column(name="A_ACCOUNT_BALANCE_AMT")
	private String aAccountBalanceAmt;

	@Column(name="A_ACCOUNT_FLAGS")
	private String aAccountFlags;

	@Column(name="A_ACCUM_PROGRESSION_CNT")
	private String aAccumProgressionCnt;

	@Column(name="A_ACCUM_PROGRESSION_VALUE_AMT")
	private String aAccumProgressionValueAmt;

	@Column(name="A_ACCUM_REFILL_CNT")
	private String aAccumRefillCnt;

	@Column(name="A_ACCUM_REFILL_VALUE_AMT")
	private String aAccumRefillValueAmt;

	@Column(name="A_COMMUNITY_ID1")
	private String aCommunityId1;

	@Column(name="A_COMMUNITY_ID2")
	private String aCommunityId2;

	@Column(name="A_COMMUNITY_ID3")
	private String aCommunityId3;

	@Column(name="A_CREDIT_CLEARANCE_PERIOD_QTY")
	private String aCreditClearancePeriodQty;

	@Column(name="A_PERMANENT_SERVICE_CLASS_CD")
	private String aPermanentServiceClassCd;

	@Column(name="A_PROMO_PLAN_CD")
	private String aPromoPlanCd;

	@Column(name="A_REFILL_OPTION_CD")
	private String aRefillOptionCd;

	@Column(name="A_SERVICE_FEE_EXPIRY_DT")
	private Timestamp aServiceFeeExpiryDt;

	@Column(name="A_SERVICE_OFFERING_CD")
	private String aServiceOfferingCd;

	@Column(name="A_SERVICE_RMV_GRACE_PERIOD_QTY")
	private String aServiceRmvGracePeriodQty;

	@Column(name="A_SUPERVISION_EXPIRY_DT")
	private Timestamp aSupervisionExpiryDt;

	@Column(name="A_TEMP_SERVICE_CLASS_CD")
	private String aTempServiceClassCd;

	@Column(name="A_TEMP_SERVICE_CLASS_EXPIRY_DT")
	private Timestamp aTempServiceClassExpiryDt;

	@Column(name="ACCOUNT_CURRENCY_CD")
	private String accountCurrencyCd;

	@Column(name="ACCOUNT_CURRENCY_CLEARED_CD")
	private String accountCurrencyClearedCd;

	@Column(name="ACCOUNT_GROUP_ID")
	private String accountGroupId;

	@Column(name="ACCOUNT_HOME_REGION_CD")
	private String accountHomeRegionCd;

	@Id
	@Column(name="ACCOUNT_NR")
	private String accountNr;

	@Column(name="ACTIVATION_DT")
	private Timestamp activationDt;

	@Column(name="AFTER_ACC_SIZE_QTY")
	private String afterAccSizeQty;

	@Column(name="AFTER_DA_SIZE_QTY")
	private String afterDaSizeQty;

	@Column(name="AO1_OFFER_EXPIRY_DT")
	private Timestamp ao1OfferExpiryDt;

	@Column(name="AO1_OFFER_ID")
	private String ao1OfferId;

	@Column(name="AO1_OFFER_START_DT")
	private Timestamp ao1OfferStartDt;

	@Column(name="AO1_OFFER_TYPE_CD")
	private String ao1OfferTypeCd;

	@Column(name="AO2_OFFER_EXPIRY_DT")
	private Timestamp ao2OfferExpiryDt;

	@Column(name="AO2_OFFER_ID")
	private String ao2OfferId;

	@Column(name="AO2_OFFER_START_DT")
	private Timestamp ao2OfferStartDt;

	@Column(name="AO2_OFFER_TYPE_CD")
	private String ao2OfferTypeCd;

	@Column(name="AO3_OFFER_EXPIRY_DT")
	private Timestamp ao3OfferExpiryDt;

	@Column(name="AO3_OFFER_ID")
	private String ao3OfferId;

	@Column(name="AO3_OFFER_START_DT")
	private Timestamp ao3OfferStartDt;

	@Column(name="AO3_OFFER_TYPE_CD")
	private String ao3OfferTypeCd;

	@Column(name="AO4_OFFER_EXPIRY_DT")
	private Timestamp ao4OfferExpiryDt;

	@Column(name="AO4_OFFER_ID")
	private String ao4OfferId;

	@Column(name="AO4_OFFER_START_DT")
	private Timestamp ao4OfferStartDt;

	@Column(name="AO4_OFFER_TYPE_CD")
	private String ao4OfferTypeCd;

	@Column(name="AO5_OFFER_EXPIRY_DT")
	private Timestamp ao5OfferExpiryDt;

	@Column(name="AO5_OFFER_ID")
	private String ao5OfferId;

	@Column(name="AO5_OFFER_START_DT")
	private Timestamp ao5OfferStartDt;

	@Column(name="AO5_OFFER_TYPE_CD")
	private String ao5OfferTypeCd;

	@Column(name="B_ACCOUNT_BALANCE_AMT")
	private String bAccountBalanceAmt;

	@Column(name="B_ACCOUNT_FLAGS")
	private String bAccountFlags;

	@Column(name="B_ACCUM_PROGRESSION_CNT")
	private String bAccumProgressionCnt;

	@Column(name="B_ACCUM_PROGRESSION_VALUE_AMT")
	private String bAccumProgressionValueAmt;

	@Column(name="B_ACCUM_REFILL_CNT")
	private String bAccumRefillCnt;

	@Column(name="B_ACCUM_REFILL_VALUE_AMT")
	private String bAccumRefillValueAmt;

	@Column(name="B_COMMUNITY_ID1")
	private String bCommunityId1;

	@Column(name="B_COMMUNITY_ID2")
	private String bCommunityId2;

	@Column(name="B_COMMUNITY_ID3")
	private String bCommunityId3;

	@Column(name="B_CREDIT_CLEARANCE_PERIOD_QTY")
	private String bCreditClearancePeriodQty;

	@Column(name="B_PERMANENT_SERVICE_CLASS_CD")
	private String bPermanentServiceClassCd;

	@Column(name="B_PROMO_PLAN_CD")
	private String bPromoPlanCd;

	@Column(name="B_REFILL_OPTION_CD")
	private String bRefillOptionCd;

	@Column(name="B_SERVICE_FEE_EXPIRY_DT")
	private Timestamp bServiceFeeExpiryDt;

	@Column(name="B_SERVICE_OFFERING_CD")
	private String bServiceOfferingCd;

	@Column(name="B_SERVICE_RMV_GRACE_PERIOD_QTY")
	private String bServiceRmvGracePeriodQty;

	@Column(name="B_SUPERVISION_EXPIRY_DT")
	private Timestamp bSupervisionExpiryDt;

	@Column(name="B_TEMP_SERVICE_CLASS_CD")
	private String bTempServiceClassCd;

	@Column(name="B_TEMP_SERVICE_CLASS_EXPIRY_DT")
	private Timestamp bTempServiceClassExpiryDt;

	@Lob
	@Column(name="BATCH_ID")
	private String batchId;

	@Column(name="BEFORE_ACC_SIZE_QTY")
	private String beforeAccSizeQty;

	@Column(name="BEFORE_DA_SIZE_QTY")
	private String beforeDaSizeQty;

	@Column(name="BO1_OFFER_EXPIRY_DT")
	private Timestamp bo1OfferExpiryDt;

	@Column(name="BO1_OFFER_ID")
	private String bo1OfferId;

	@Column(name="BO1_OFFER_START_DT")
	private Timestamp bo1OfferStartDt;

	@Column(name="BO1_OFFER_TYPE_CD")
	private String bo1OfferTypeCd;

	@Column(name="BO2_OFFER_EXPIRY_DT")
	private Timestamp bo2OfferExpiryDt;

	@Column(name="BO2_OFFER_ID")
	private String bo2OfferId;

	@Column(name="BO2_OFFER_START_DT")
	private Timestamp bo2OfferStartDt;

	@Column(name="BO2_OFFER_TYPE_CD")
	private String bo2OfferTypeCd;

	@Column(name="BO3_OFFER_EXPIRY_DT")
	private Timestamp bo3OfferExpiryDt;

	@Column(name="BO3_OFFER_ID")
	private String bo3OfferId;

	@Column(name="BO3_OFFER_START_DT")
	private Timestamp bo3OfferStartDt;

	@Column(name="BO3_OFFER_TYPE_CD")
	private String bo3OfferTypeCd;

	@Column(name="BO4_OFFER_EXPIRY_DT")
	private Timestamp bo4OfferExpiryDt;

	@Column(name="BO4_OFFER_ID")
	private String bo4OfferId;

	@Column(name="BO4_OFFER_START_DT")
	private Timestamp bo4OfferStartDt;

	@Column(name="BO4_OFFER_TYPE_CD")
	private String bo4OfferTypeCd;

	@Column(name="BO5_OFFER_EXPIRY_DT")
	private Timestamp bo5OfferExpiryDt;

	@Column(name="BO5_OFFER_ID")
	private String bo5OfferId;

	@Column(name="BO5_OFFER_START_DT")
	private Timestamp bo5OfferStartDt;

	@Column(name="BO5_OFFER_TYPE_CD")
	private String bo5OfferTypeCd;

	@Column(name="CALL_REFERENCE_ID")
	private String callReferenceId;

	@Column(name="CELL_GLOBAL_ID")
	private String cellGlobalId;

	@Column(name="CREATE_DT")
	private Timestamp createDt;

	@Column(name="CURRENT_SERVICE_CLASS_CD")
	private String currentServiceClassCd;

	@Lob
	@Column(name="DATE_KEY")
	private String dateKey;

	@Column(name="DF1_PARAMETER_ID")
	private String df1ParameterId;

	@Column(name="DF1_PARAMETER_VALUE_AMT")
	private String df1ParameterValueAmt;

	@Column(name="DF2_PARAMETER_ID")
	private String df2ParameterId;

	@Column(name="DF2_PARAMETER_VALUE_AMT")
	private String df2ParameterValueAmt;

	@Column(name="DF3_PARAMETER_ID")
	private String df3ParameterId;

	@Column(name="DF3_PARAMETER_VALUE_AMT")
	private String df3ParameterValueAmt;

	@Column(name="DF4_PARAMETER_ID")
	private String df4ParameterId;

	@Column(name="DF4_PARAMETER_VALUE_AMT")
	private String df4ParameterValueAmt;

	@Column(name="DF5_PARAMETER_ID")
	private String df5ParameterId;

	@Column(name="DF5_PARAMETER_VALUE_AMT")
	private String df5ParameterValueAmt;

	@Lob
	@Column(name="DW_FILE_ID")
	private String dwFileId;

	@Lob
	@Column(name="DW_FILE_ROW_NUMBER")
	private String dwFileRowNumber;

	@Lob
	@Column(name="DW_SUBPART")
	private String dwSubpart;

	@Column(name="EDR_TYPE_CD")
	private String edrTypeCd;

	@Column(name="EVENT_DT")
	private Timestamp eventDt;

	@Column(name="EXTERNAL_DATA1")
	private String externalData1;

	@Column(name="EXTERNAL_DATA2")
	private String externalData2;

	@Column(name="EXTERNAL_DATA3")
	private String externalData3;

	@Column(name="EXTERNAL_DATA4")
	private String externalData4;

	@Column(name="FLEX_1_TXT")
	private String flex1Txt;

	@Column(name="FLEX_2_TXT")
	private String flex2Txt;

	@Column(name="FLEX_3_TXT")
	private String flex3Txt;

	@Column(name="FLEX_4_TXT")
	private String flex4Txt;

	@Column(name="FLEX_5_TXT")
	private String flex5Txt;

	@Column(name="HOST_NM")
	private String hostNm;

	@Column(name="IGNORE_SERV_CLASS_HIER_IND")
	private String ignoreServClassHierInd;

	@Column(name="LOCAL_SEQUENCE_NR")
	private String localSequenceNr;

	@Column(name="LOCATION_NR")
	private String locationNr;

	@Column(name="MA_AMOUNT_USED")
	private String maAmountUsed;

	@Column(name="MAX_SERVICE_FEE_PERIOD_QTY")
	private String maxServiceFeePeriodQty;

	@Column(name="MAX_SUPERVISION_PERIOD_QTY")
	private String maxSupervisionPeriodQty;

	@Column(name="ORIGIN_FILE_ID")
	private String originFileId;

	@Column(name="ORIGIN_HOST_NM")
	private String originHostNm;

	@Column(name="ORIGIN_NODE_TYPE_CD")
	private String originNodeTypeCd;

	@Column(name="ORIGIN_OPERATOR_ID")
	private String originOperatorId;

	@Column(name="ORIGIN_TIME_STAMP")
	private Timestamp originTimeStamp;

	@Column(name="ORIGIN_TRANSACTION_ID")
	private String originTransactionId;

	private String paytype;

	@Column(name="PROMO_ANNOUNCEMENT_CD")
	private String promoAnnouncementCd;

	@Column(name="PROMO_PLAN_ALLOC_END_DT")
	private Timestamp promoPlanAllocEndDt;

	@Column(name="PROMO_PLAN_ALLOC_START_DT")
	private Timestamp promoPlanAllocStartDt;

	@Column(name="REFILL_CONVERTED_AMT")
	private String refillConvertedAmt;

	@Column(name="REFILL_DIVISION_AMT")
	private String refillDivisionAmt;

	@Column(name="REFILL_PROFILE_ID")
	private String refillProfileId;

	@Column(name="REFILL_PROMO_DIVISION_AMT")
	private String refillPromoDivisionAmt;

	@Column(name="REFILL_TYPE_CD")
	private String refillTypeCd;

	@Column(name="REQUESTED_REFILL_TYPE_CD")
	private String requestedRefillTypeCd;

	@Column(name="SEGMENTATION_ID")
	private String segmentationId;

	@Column(name="SERVICE_CLASS_ID")
	private String serviceClassId;

	@Column(name="SERVICE_FEE_DAYS_PROMO_PART")
	private String serviceFeeDaysPromoPart;

	@Column(name="SERVICE_FEE_DAYS_SURPLUS")
	private String serviceFeeDaysSurplus;

	@Column(name="ST1_SELECTION_TREE_ID")
	private String st1SelectionTreeId;

	@Column(name="ST1_SELECTION_TREE_VERSION_NM")
	private String st1SelectionTreeVersionNm;

	@Column(name="ST2_SELECTION_TREE_ID")
	private String st2SelectionTreeId;

	@Column(name="ST2_SELECTION_TREE_VERSION_NM")
	private String st2SelectionTreeVersionNm;

	@Column(name="ST3_SELECTION_TREE_ID")
	private String st3SelectionTreeId;

	@Column(name="ST3_SELECTION_TREE_VERSION_NM")
	private String st3SelectionTreeVersionNm;

	@Column(name="ST4_SELECTION_TREE_ID")
	private String st4SelectionTreeId;

	@Column(name="ST4_SELECTION_TREE_VERSION_NM")
	private String st4SelectionTreeVersionNm;

	@Column(name="ST5_SELECTION_TREE_ID")
	private String st5SelectionTreeId;

	@Column(name="ST5_SELECTION_TREE_VERSION_NM")
	private String st5SelectionTreeVersionNm;

	@Lob
	@Column(name="SUBSCRIBER_NR")
	private String subscriberNr;

	@Column(name="SUBSCRIBER_REGION_CD")
	private String subscriberRegionCd;

	@Column(name="SUPERVISION_DAYS_PROMO_PART")
	private String supervisionDaysPromoPart;

	@Column(name="SUPERVISION_DAYS_SURPLUS")
	private String supervisionDaysSurplus;

	@Column(name="TRANSACTION_AMT")
	private String transactionAmt;

	@Column(name="TRANSACTION_CD")
	private String transactionCd;

	@Column(name="TRANSACTION_CURRENCY_CD")
	private String transactionCurrencyCd;

	@Column(name="TRANSACTION_TYPE_CD")
	private String transactionTypeCd;

	@Column(name="VOUCHER_ACTIVATION_CD")
	private String voucherActivationCd;

	@Column(name="VOUCHER_AGENT_CD")
	private String voucherAgentCd;

	@Column(name="VOUCHER_BASED_REFILL_IND")
	private String voucherBasedRefillInd;

	@Column(name="VOUCHER_GROUP_ID")
	private String voucherGroupId;

	@Column(name="VOUCHER_REGION_CD")
	private String voucherRegionCd;

	@Column(name="VOUCHER_SERIAL_NR")
	private String voucherSerialNr;

	@Column(name="WELCOME_STATUS_IND")
	private String welcomeStatusInd;

	public StgCs5AirRefillMa() {
	}

	public String getAAccountBalanceAmt() {
		return this.aAccountBalanceAmt;
	}

	public void setAAccountBalanceAmt(String aAccountBalanceAmt) {
		this.aAccountBalanceAmt = aAccountBalanceAmt;
	}

	public String getAAccountFlags() {
		return this.aAccountFlags;
	}

	public void setAAccountFlags(String aAccountFlags) {
		this.aAccountFlags = aAccountFlags;
	}

	public String getAAccumProgressionCnt() {
		return this.aAccumProgressionCnt;
	}

	public void setAAccumProgressionCnt(String aAccumProgressionCnt) {
		this.aAccumProgressionCnt = aAccumProgressionCnt;
	}

	public String getAAccumProgressionValueAmt() {
		return this.aAccumProgressionValueAmt;
	}

	public void setAAccumProgressionValueAmt(String aAccumProgressionValueAmt) {
		this.aAccumProgressionValueAmt = aAccumProgressionValueAmt;
	}

	public String getAAccumRefillCnt() {
		return this.aAccumRefillCnt;
	}

	public void setAAccumRefillCnt(String aAccumRefillCnt) {
		this.aAccumRefillCnt = aAccumRefillCnt;
	}

	public String getAAccumRefillValueAmt() {
		return this.aAccumRefillValueAmt;
	}

	public void setAAccumRefillValueAmt(String aAccumRefillValueAmt) {
		this.aAccumRefillValueAmt = aAccumRefillValueAmt;
	}

	public String getACommunityId1() {
		return this.aCommunityId1;
	}

	public void setACommunityId1(String aCommunityId1) {
		this.aCommunityId1 = aCommunityId1;
	}

	public String getACommunityId2() {
		return this.aCommunityId2;
	}

	public void setACommunityId2(String aCommunityId2) {
		this.aCommunityId2 = aCommunityId2;
	}

	public String getACommunityId3() {
		return this.aCommunityId3;
	}

	public void setACommunityId3(String aCommunityId3) {
		this.aCommunityId3 = aCommunityId3;
	}

	public String getACreditClearancePeriodQty() {
		return this.aCreditClearancePeriodQty;
	}

	public void setACreditClearancePeriodQty(String aCreditClearancePeriodQty) {
		this.aCreditClearancePeriodQty = aCreditClearancePeriodQty;
	}

	public String getAPermanentServiceClassCd() {
		return this.aPermanentServiceClassCd;
	}

	public void setAPermanentServiceClassCd(String aPermanentServiceClassCd) {
		this.aPermanentServiceClassCd = aPermanentServiceClassCd;
	}

	public String getAPromoPlanCd() {
		return this.aPromoPlanCd;
	}

	public void setAPromoPlanCd(String aPromoPlanCd) {
		this.aPromoPlanCd = aPromoPlanCd;
	}

	public String getARefillOptionCd() {
		return this.aRefillOptionCd;
	}

	public void setARefillOptionCd(String aRefillOptionCd) {
		this.aRefillOptionCd = aRefillOptionCd;
	}

	public Timestamp getAServiceFeeExpiryDt() {
		return this.aServiceFeeExpiryDt;
	}

	public void setAServiceFeeExpiryDt(Timestamp aServiceFeeExpiryDt) {
		this.aServiceFeeExpiryDt = aServiceFeeExpiryDt;
	}

	public String getAServiceOfferingCd() {
		return this.aServiceOfferingCd;
	}

	public void setAServiceOfferingCd(String aServiceOfferingCd) {
		this.aServiceOfferingCd = aServiceOfferingCd;
	}

	public String getAServiceRmvGracePeriodQty() {
		return this.aServiceRmvGracePeriodQty;
	}

	public void setAServiceRmvGracePeriodQty(String aServiceRmvGracePeriodQty) {
		this.aServiceRmvGracePeriodQty = aServiceRmvGracePeriodQty;
	}

	public Timestamp getASupervisionExpiryDt() {
		return this.aSupervisionExpiryDt;
	}

	public void setASupervisionExpiryDt(Timestamp aSupervisionExpiryDt) {
		this.aSupervisionExpiryDt = aSupervisionExpiryDt;
	}

	public String getATempServiceClassCd() {
		return this.aTempServiceClassCd;
	}

	public void setATempServiceClassCd(String aTempServiceClassCd) {
		this.aTempServiceClassCd = aTempServiceClassCd;
	}

	public Timestamp getATempServiceClassExpiryDt() {
		return this.aTempServiceClassExpiryDt;
	}

	public void setATempServiceClassExpiryDt(Timestamp aTempServiceClassExpiryDt) {
		this.aTempServiceClassExpiryDt = aTempServiceClassExpiryDt;
	}

	public String getAccountCurrencyCd() {
		return this.accountCurrencyCd;
	}

	public void setAccountCurrencyCd(String accountCurrencyCd) {
		this.accountCurrencyCd = accountCurrencyCd;
	}

	public String getAccountCurrencyClearedCd() {
		return this.accountCurrencyClearedCd;
	}

	public void setAccountCurrencyClearedCd(String accountCurrencyClearedCd) {
		this.accountCurrencyClearedCd = accountCurrencyClearedCd;
	}

	public String getAccountGroupId() {
		return this.accountGroupId;
	}

	public void setAccountGroupId(String accountGroupId) {
		this.accountGroupId = accountGroupId;
	}

	public String getAccountHomeRegionCd() {
		return this.accountHomeRegionCd;
	}

	public void setAccountHomeRegionCd(String accountHomeRegionCd) {
		this.accountHomeRegionCd = accountHomeRegionCd;
	}

	public String getAccountNr() {
		return this.accountNr;
	}

	public void setAccountNr(String accountNr) {
		this.accountNr = accountNr;
	}

	public Timestamp getActivationDt() {
		return this.activationDt;
	}

	public void setActivationDt(Timestamp activationDt) {
		this.activationDt = activationDt;
	}

	public String getAfterAccSizeQty() {
		return this.afterAccSizeQty;
	}

	public void setAfterAccSizeQty(String afterAccSizeQty) {
		this.afterAccSizeQty = afterAccSizeQty;
	}

	public String getAfterDaSizeQty() {
		return this.afterDaSizeQty;
	}

	public void setAfterDaSizeQty(String afterDaSizeQty) {
		this.afterDaSizeQty = afterDaSizeQty;
	}

	public Timestamp getAo1OfferExpiryDt() {
		return this.ao1OfferExpiryDt;
	}

	public void setAo1OfferExpiryDt(Timestamp ao1OfferExpiryDt) {
		this.ao1OfferExpiryDt = ao1OfferExpiryDt;
	}

	public String getAo1OfferId() {
		return this.ao1OfferId;
	}

	public void setAo1OfferId(String ao1OfferId) {
		this.ao1OfferId = ao1OfferId;
	}

	public Timestamp getAo1OfferStartDt() {
		return this.ao1OfferStartDt;
	}

	public void setAo1OfferStartDt(Timestamp ao1OfferStartDt) {
		this.ao1OfferStartDt = ao1OfferStartDt;
	}

	public String getAo1OfferTypeCd() {
		return this.ao1OfferTypeCd;
	}

	public void setAo1OfferTypeCd(String ao1OfferTypeCd) {
		this.ao1OfferTypeCd = ao1OfferTypeCd;
	}

	public Timestamp getAo2OfferExpiryDt() {
		return this.ao2OfferExpiryDt;
	}

	public void setAo2OfferExpiryDt(Timestamp ao2OfferExpiryDt) {
		this.ao2OfferExpiryDt = ao2OfferExpiryDt;
	}

	public String getAo2OfferId() {
		return this.ao2OfferId;
	}

	public void setAo2OfferId(String ao2OfferId) {
		this.ao2OfferId = ao2OfferId;
	}

	public Timestamp getAo2OfferStartDt() {
		return this.ao2OfferStartDt;
	}

	public void setAo2OfferStartDt(Timestamp ao2OfferStartDt) {
		this.ao2OfferStartDt = ao2OfferStartDt;
	}

	public String getAo2OfferTypeCd() {
		return this.ao2OfferTypeCd;
	}

	public void setAo2OfferTypeCd(String ao2OfferTypeCd) {
		this.ao2OfferTypeCd = ao2OfferTypeCd;
	}

	public Timestamp getAo3OfferExpiryDt() {
		return this.ao3OfferExpiryDt;
	}

	public void setAo3OfferExpiryDt(Timestamp ao3OfferExpiryDt) {
		this.ao3OfferExpiryDt = ao3OfferExpiryDt;
	}

	public String getAo3OfferId() {
		return this.ao3OfferId;
	}

	public void setAo3OfferId(String ao3OfferId) {
		this.ao3OfferId = ao3OfferId;
	}

	public Timestamp getAo3OfferStartDt() {
		return this.ao3OfferStartDt;
	}

	public void setAo3OfferStartDt(Timestamp ao3OfferStartDt) {
		this.ao3OfferStartDt = ao3OfferStartDt;
	}

	public String getAo3OfferTypeCd() {
		return this.ao3OfferTypeCd;
	}

	public void setAo3OfferTypeCd(String ao3OfferTypeCd) {
		this.ao3OfferTypeCd = ao3OfferTypeCd;
	}

	public Timestamp getAo4OfferExpiryDt() {
		return this.ao4OfferExpiryDt;
	}

	public void setAo4OfferExpiryDt(Timestamp ao4OfferExpiryDt) {
		this.ao4OfferExpiryDt = ao4OfferExpiryDt;
	}

	public String getAo4OfferId() {
		return this.ao4OfferId;
	}

	public void setAo4OfferId(String ao4OfferId) {
		this.ao4OfferId = ao4OfferId;
	}

	public Timestamp getAo4OfferStartDt() {
		return this.ao4OfferStartDt;
	}

	public void setAo4OfferStartDt(Timestamp ao4OfferStartDt) {
		this.ao4OfferStartDt = ao4OfferStartDt;
	}

	public String getAo4OfferTypeCd() {
		return this.ao4OfferTypeCd;
	}

	public void setAo4OfferTypeCd(String ao4OfferTypeCd) {
		this.ao4OfferTypeCd = ao4OfferTypeCd;
	}

	public Timestamp getAo5OfferExpiryDt() {
		return this.ao5OfferExpiryDt;
	}

	public void setAo5OfferExpiryDt(Timestamp ao5OfferExpiryDt) {
		this.ao5OfferExpiryDt = ao5OfferExpiryDt;
	}

	public String getAo5OfferId() {
		return this.ao5OfferId;
	}

	public void setAo5OfferId(String ao5OfferId) {
		this.ao5OfferId = ao5OfferId;
	}

	public Timestamp getAo5OfferStartDt() {
		return this.ao5OfferStartDt;
	}

	public void setAo5OfferStartDt(Timestamp ao5OfferStartDt) {
		this.ao5OfferStartDt = ao5OfferStartDt;
	}

	public String getAo5OfferTypeCd() {
		return this.ao5OfferTypeCd;
	}

	public void setAo5OfferTypeCd(String ao5OfferTypeCd) {
		this.ao5OfferTypeCd = ao5OfferTypeCd;
	}

	public String getBAccountBalanceAmt() {
		return this.bAccountBalanceAmt;
	}

	public void setBAccountBalanceAmt(String bAccountBalanceAmt) {
		this.bAccountBalanceAmt = bAccountBalanceAmt;
	}

	public String getBAccountFlags() {
		return this.bAccountFlags;
	}

	public void setBAccountFlags(String bAccountFlags) {
		this.bAccountFlags = bAccountFlags;
	}

	public String getBAccumProgressionCnt() {
		return this.bAccumProgressionCnt;
	}

	public void setBAccumProgressionCnt(String bAccumProgressionCnt) {
		this.bAccumProgressionCnt = bAccumProgressionCnt;
	}

	public String getBAccumProgressionValueAmt() {
		return this.bAccumProgressionValueAmt;
	}

	public void setBAccumProgressionValueAmt(String bAccumProgressionValueAmt) {
		this.bAccumProgressionValueAmt = bAccumProgressionValueAmt;
	}

	public String getBAccumRefillCnt() {
		return this.bAccumRefillCnt;
	}

	public void setBAccumRefillCnt(String bAccumRefillCnt) {
		this.bAccumRefillCnt = bAccumRefillCnt;
	}

	public String getBAccumRefillValueAmt() {
		return this.bAccumRefillValueAmt;
	}

	public void setBAccumRefillValueAmt(String bAccumRefillValueAmt) {
		this.bAccumRefillValueAmt = bAccumRefillValueAmt;
	}

	public String getBCommunityId1() {
		return this.bCommunityId1;
	}

	public void setBCommunityId1(String bCommunityId1) {
		this.bCommunityId1 = bCommunityId1;
	}

	public String getBCommunityId2() {
		return this.bCommunityId2;
	}

	public void setBCommunityId2(String bCommunityId2) {
		this.bCommunityId2 = bCommunityId2;
	}

	public String getBCommunityId3() {
		return this.bCommunityId3;
	}

	public void setBCommunityId3(String bCommunityId3) {
		this.bCommunityId3 = bCommunityId3;
	}

	public String getBCreditClearancePeriodQty() {
		return this.bCreditClearancePeriodQty;
	}

	public void setBCreditClearancePeriodQty(String bCreditClearancePeriodQty) {
		this.bCreditClearancePeriodQty = bCreditClearancePeriodQty;
	}

	public String getBPermanentServiceClassCd() {
		return this.bPermanentServiceClassCd;
	}

	public void setBPermanentServiceClassCd(String bPermanentServiceClassCd) {
		this.bPermanentServiceClassCd = bPermanentServiceClassCd;
	}

	public String getBPromoPlanCd() {
		return this.bPromoPlanCd;
	}

	public void setBPromoPlanCd(String bPromoPlanCd) {
		this.bPromoPlanCd = bPromoPlanCd;
	}

	public String getBRefillOptionCd() {
		return this.bRefillOptionCd;
	}

	public void setBRefillOptionCd(String bRefillOptionCd) {
		this.bRefillOptionCd = bRefillOptionCd;
	}

	public Timestamp getBServiceFeeExpiryDt() {
		return this.bServiceFeeExpiryDt;
	}

	public void setBServiceFeeExpiryDt(Timestamp bServiceFeeExpiryDt) {
		this.bServiceFeeExpiryDt = bServiceFeeExpiryDt;
	}

	public String getBServiceOfferingCd() {
		return this.bServiceOfferingCd;
	}

	public void setBServiceOfferingCd(String bServiceOfferingCd) {
		this.bServiceOfferingCd = bServiceOfferingCd;
	}

	public String getBServiceRmvGracePeriodQty() {
		return this.bServiceRmvGracePeriodQty;
	}

	public void setBServiceRmvGracePeriodQty(String bServiceRmvGracePeriodQty) {
		this.bServiceRmvGracePeriodQty = bServiceRmvGracePeriodQty;
	}

	public Timestamp getBSupervisionExpiryDt() {
		return this.bSupervisionExpiryDt;
	}

	public void setBSupervisionExpiryDt(Timestamp bSupervisionExpiryDt) {
		this.bSupervisionExpiryDt = bSupervisionExpiryDt;
	}

	public String getBTempServiceClassCd() {
		return this.bTempServiceClassCd;
	}

	public void setBTempServiceClassCd(String bTempServiceClassCd) {
		this.bTempServiceClassCd = bTempServiceClassCd;
	}

	public Timestamp getBTempServiceClassExpiryDt() {
		return this.bTempServiceClassExpiryDt;
	}

	public void setBTempServiceClassExpiryDt(Timestamp bTempServiceClassExpiryDt) {
		this.bTempServiceClassExpiryDt = bTempServiceClassExpiryDt;
	}

	public String getBatchId() {
		return this.batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getBeforeAccSizeQty() {
		return this.beforeAccSizeQty;
	}

	public void setBeforeAccSizeQty(String beforeAccSizeQty) {
		this.beforeAccSizeQty = beforeAccSizeQty;
	}

	public String getBeforeDaSizeQty() {
		return this.beforeDaSizeQty;
	}

	public void setBeforeDaSizeQty(String beforeDaSizeQty) {
		this.beforeDaSizeQty = beforeDaSizeQty;
	}

	public Timestamp getBo1OfferExpiryDt() {
		return this.bo1OfferExpiryDt;
	}

	public void setBo1OfferExpiryDt(Timestamp bo1OfferExpiryDt) {
		this.bo1OfferExpiryDt = bo1OfferExpiryDt;
	}

	public String getBo1OfferId() {
		return this.bo1OfferId;
	}

	public void setBo1OfferId(String bo1OfferId) {
		this.bo1OfferId = bo1OfferId;
	}

	public Timestamp getBo1OfferStartDt() {
		return this.bo1OfferStartDt;
	}

	public void setBo1OfferStartDt(Timestamp bo1OfferStartDt) {
		this.bo1OfferStartDt = bo1OfferStartDt;
	}

	public String getBo1OfferTypeCd() {
		return this.bo1OfferTypeCd;
	}

	public void setBo1OfferTypeCd(String bo1OfferTypeCd) {
		this.bo1OfferTypeCd = bo1OfferTypeCd;
	}

	public Timestamp getBo2OfferExpiryDt() {
		return this.bo2OfferExpiryDt;
	}

	public void setBo2OfferExpiryDt(Timestamp bo2OfferExpiryDt) {
		this.bo2OfferExpiryDt = bo2OfferExpiryDt;
	}

	public String getBo2OfferId() {
		return this.bo2OfferId;
	}

	public void setBo2OfferId(String bo2OfferId) {
		this.bo2OfferId = bo2OfferId;
	}

	public Timestamp getBo2OfferStartDt() {
		return this.bo2OfferStartDt;
	}

	public void setBo2OfferStartDt(Timestamp bo2OfferStartDt) {
		this.bo2OfferStartDt = bo2OfferStartDt;
	}

	public String getBo2OfferTypeCd() {
		return this.bo2OfferTypeCd;
	}

	public void setBo2OfferTypeCd(String bo2OfferTypeCd) {
		this.bo2OfferTypeCd = bo2OfferTypeCd;
	}

	public Timestamp getBo3OfferExpiryDt() {
		return this.bo3OfferExpiryDt;
	}

	public void setBo3OfferExpiryDt(Timestamp bo3OfferExpiryDt) {
		this.bo3OfferExpiryDt = bo3OfferExpiryDt;
	}

	public String getBo3OfferId() {
		return this.bo3OfferId;
	}

	public void setBo3OfferId(String bo3OfferId) {
		this.bo3OfferId = bo3OfferId;
	}

	public Timestamp getBo3OfferStartDt() {
		return this.bo3OfferStartDt;
	}

	public void setBo3OfferStartDt(Timestamp bo3OfferStartDt) {
		this.bo3OfferStartDt = bo3OfferStartDt;
	}

	public String getBo3OfferTypeCd() {
		return this.bo3OfferTypeCd;
	}

	public void setBo3OfferTypeCd(String bo3OfferTypeCd) {
		this.bo3OfferTypeCd = bo3OfferTypeCd;
	}

	public Timestamp getBo4OfferExpiryDt() {
		return this.bo4OfferExpiryDt;
	}

	public void setBo4OfferExpiryDt(Timestamp bo4OfferExpiryDt) {
		this.bo4OfferExpiryDt = bo4OfferExpiryDt;
	}

	public String getBo4OfferId() {
		return this.bo4OfferId;
	}

	public void setBo4OfferId(String bo4OfferId) {
		this.bo4OfferId = bo4OfferId;
	}

	public Timestamp getBo4OfferStartDt() {
		return this.bo4OfferStartDt;
	}

	public void setBo4OfferStartDt(Timestamp bo4OfferStartDt) {
		this.bo4OfferStartDt = bo4OfferStartDt;
	}

	public String getBo4OfferTypeCd() {
		return this.bo4OfferTypeCd;
	}

	public void setBo4OfferTypeCd(String bo4OfferTypeCd) {
		this.bo4OfferTypeCd = bo4OfferTypeCd;
	}

	public Timestamp getBo5OfferExpiryDt() {
		return this.bo5OfferExpiryDt;
	}

	public void setBo5OfferExpiryDt(Timestamp bo5OfferExpiryDt) {
		this.bo5OfferExpiryDt = bo5OfferExpiryDt;
	}

	public String getBo5OfferId() {
		return this.bo5OfferId;
	}

	public void setBo5OfferId(String bo5OfferId) {
		this.bo5OfferId = bo5OfferId;
	}

	public Timestamp getBo5OfferStartDt() {
		return this.bo5OfferStartDt;
	}

	public void setBo5OfferStartDt(Timestamp bo5OfferStartDt) {
		this.bo5OfferStartDt = bo5OfferStartDt;
	}

	public String getBo5OfferTypeCd() {
		return this.bo5OfferTypeCd;
	}

	public void setBo5OfferTypeCd(String bo5OfferTypeCd) {
		this.bo5OfferTypeCd = bo5OfferTypeCd;
	}

	public String getCallReferenceId() {
		return this.callReferenceId;
	}

	public void setCallReferenceId(String callReferenceId) {
		this.callReferenceId = callReferenceId;
	}

	public String getCellGlobalId() {
		return this.cellGlobalId;
	}

	public void setCellGlobalId(String cellGlobalId) {
		this.cellGlobalId = cellGlobalId;
	}

	public Timestamp getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Timestamp createDt) {
		this.createDt = createDt;
	}

	public String getCurrentServiceClassCd() {
		return this.currentServiceClassCd;
	}

	public void setCurrentServiceClassCd(String currentServiceClassCd) {
		this.currentServiceClassCd = currentServiceClassCd;
	}

	public String getDateKey() {
		return this.dateKey;
	}

	public void setDateKey(String dateKey) {
		this.dateKey = dateKey;
	}

	public String getDf1ParameterId() {
		return this.df1ParameterId;
	}

	public void setDf1ParameterId(String df1ParameterId) {
		this.df1ParameterId = df1ParameterId;
	}

	public String getDf1ParameterValueAmt() {
		return this.df1ParameterValueAmt;
	}

	public void setDf1ParameterValueAmt(String df1ParameterValueAmt) {
		this.df1ParameterValueAmt = df1ParameterValueAmt;
	}

	public String getDf2ParameterId() {
		return this.df2ParameterId;
	}

	public void setDf2ParameterId(String df2ParameterId) {
		this.df2ParameterId = df2ParameterId;
	}

	public String getDf2ParameterValueAmt() {
		return this.df2ParameterValueAmt;
	}

	public void setDf2ParameterValueAmt(String df2ParameterValueAmt) {
		this.df2ParameterValueAmt = df2ParameterValueAmt;
	}

	public String getDf3ParameterId() {
		return this.df3ParameterId;
	}

	public void setDf3ParameterId(String df3ParameterId) {
		this.df3ParameterId = df3ParameterId;
	}

	public String getDf3ParameterValueAmt() {
		return this.df3ParameterValueAmt;
	}

	public void setDf3ParameterValueAmt(String df3ParameterValueAmt) {
		this.df3ParameterValueAmt = df3ParameterValueAmt;
	}

	public String getDf4ParameterId() {
		return this.df4ParameterId;
	}

	public void setDf4ParameterId(String df4ParameterId) {
		this.df4ParameterId = df4ParameterId;
	}

	public String getDf4ParameterValueAmt() {
		return this.df4ParameterValueAmt;
	}

	public void setDf4ParameterValueAmt(String df4ParameterValueAmt) {
		this.df4ParameterValueAmt = df4ParameterValueAmt;
	}

	public String getDf5ParameterId() {
		return this.df5ParameterId;
	}

	public void setDf5ParameterId(String df5ParameterId) {
		this.df5ParameterId = df5ParameterId;
	}

	public String getDf5ParameterValueAmt() {
		return this.df5ParameterValueAmt;
	}

	public void setDf5ParameterValueAmt(String df5ParameterValueAmt) {
		this.df5ParameterValueAmt = df5ParameterValueAmt;
	}

	public String getDwFileId() {
		return this.dwFileId;
	}

	public void setDwFileId(String dwFileId) {
		this.dwFileId = dwFileId;
	}

	public String getDwFileRowNumber() {
		return this.dwFileRowNumber;
	}

	public void setDwFileRowNumber(String dwFileRowNumber) {
		this.dwFileRowNumber = dwFileRowNumber;
	}

	public String getDwSubpart() {
		return this.dwSubpart;
	}

	public void setDwSubpart(String dwSubpart) {
		this.dwSubpart = dwSubpart;
	}

	public String getEdrTypeCd() {
		return this.edrTypeCd;
	}

	public void setEdrTypeCd(String edrTypeCd) {
		this.edrTypeCd = edrTypeCd;
	}

	public Timestamp getEventDt() {
		return this.eventDt;
	}

	public void setEventDt(Timestamp eventDt) {
		this.eventDt = eventDt;
	}

	public String getExternalData1() {
		return this.externalData1;
	}

	public void setExternalData1(String externalData1) {
		this.externalData1 = externalData1;
	}

	public String getExternalData2() {
		return this.externalData2;
	}

	public void setExternalData2(String externalData2) {
		this.externalData2 = externalData2;
	}

	public String getExternalData3() {
		return this.externalData3;
	}

	public void setExternalData3(String externalData3) {
		this.externalData3 = externalData3;
	}

	public String getExternalData4() {
		return this.externalData4;
	}

	public void setExternalData4(String externalData4) {
		this.externalData4 = externalData4;
	}

	public String getFlex1Txt() {
		return this.flex1Txt;
	}

	public void setFlex1Txt(String flex1Txt) {
		this.flex1Txt = flex1Txt;
	}

	public String getFlex2Txt() {
		return this.flex2Txt;
	}

	public void setFlex2Txt(String flex2Txt) {
		this.flex2Txt = flex2Txt;
	}

	public String getFlex3Txt() {
		return this.flex3Txt;
	}

	public void setFlex3Txt(String flex3Txt) {
		this.flex3Txt = flex3Txt;
	}

	public String getFlex4Txt() {
		return this.flex4Txt;
	}

	public void setFlex4Txt(String flex4Txt) {
		this.flex4Txt = flex4Txt;
	}

	public String getFlex5Txt() {
		return this.flex5Txt;
	}

	public void setFlex5Txt(String flex5Txt) {
		this.flex5Txt = flex5Txt;
	}

	public String getHostNm() {
		return this.hostNm;
	}

	public void setHostNm(String hostNm) {
		this.hostNm = hostNm;
	}

	public String getIgnoreServClassHierInd() {
		return this.ignoreServClassHierInd;
	}

	public void setIgnoreServClassHierInd(String ignoreServClassHierInd) {
		this.ignoreServClassHierInd = ignoreServClassHierInd;
	}

	public String getLocalSequenceNr() {
		return this.localSequenceNr;
	}

	public void setLocalSequenceNr(String localSequenceNr) {
		this.localSequenceNr = localSequenceNr;
	}

	public String getLocationNr() {
		return this.locationNr;
	}

	public void setLocationNr(String locationNr) {
		this.locationNr = locationNr;
	}

	public String getMaAmountUsed() {
		return this.maAmountUsed;
	}

	public void setMaAmountUsed(String maAmountUsed) {
		this.maAmountUsed = maAmountUsed;
	}

	public String getMaxServiceFeePeriodQty() {
		return this.maxServiceFeePeriodQty;
	}

	public void setMaxServiceFeePeriodQty(String maxServiceFeePeriodQty) {
		this.maxServiceFeePeriodQty = maxServiceFeePeriodQty;
	}

	public String getMaxSupervisionPeriodQty() {
		return this.maxSupervisionPeriodQty;
	}

	public void setMaxSupervisionPeriodQty(String maxSupervisionPeriodQty) {
		this.maxSupervisionPeriodQty = maxSupervisionPeriodQty;
	}

	public String getOriginFileId() {
		return this.originFileId;
	}

	public void setOriginFileId(String originFileId) {
		this.originFileId = originFileId;
	}

	public String getOriginHostNm() {
		return this.originHostNm;
	}

	public void setOriginHostNm(String originHostNm) {
		this.originHostNm = originHostNm;
	}

	public String getOriginNodeTypeCd() {
		return this.originNodeTypeCd;
	}

	public void setOriginNodeTypeCd(String originNodeTypeCd) {
		this.originNodeTypeCd = originNodeTypeCd;
	}

	public String getOriginOperatorId() {
		return this.originOperatorId;
	}

	public void setOriginOperatorId(String originOperatorId) {
		this.originOperatorId = originOperatorId;
	}

	public Timestamp getOriginTimeStamp() {
		return this.originTimeStamp;
	}

	public void setOriginTimeStamp(Timestamp originTimeStamp) {
		this.originTimeStamp = originTimeStamp;
	}

	public String getOriginTransactionId() {
		return this.originTransactionId;
	}

	public void setOriginTransactionId(String originTransactionId) {
		this.originTransactionId = originTransactionId;
	}

	public String getPaytype() {
		return this.paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public String getPromoAnnouncementCd() {
		return this.promoAnnouncementCd;
	}

	public void setPromoAnnouncementCd(String promoAnnouncementCd) {
		this.promoAnnouncementCd = promoAnnouncementCd;
	}

	public Timestamp getPromoPlanAllocEndDt() {
		return this.promoPlanAllocEndDt;
	}

	public void setPromoPlanAllocEndDt(Timestamp promoPlanAllocEndDt) {
		this.promoPlanAllocEndDt = promoPlanAllocEndDt;
	}

	public Timestamp getPromoPlanAllocStartDt() {
		return this.promoPlanAllocStartDt;
	}

	public void setPromoPlanAllocStartDt(Timestamp promoPlanAllocStartDt) {
		this.promoPlanAllocStartDt = promoPlanAllocStartDt;
	}

	public String getRefillConvertedAmt() {
		return this.refillConvertedAmt;
	}

	public void setRefillConvertedAmt(String refillConvertedAmt) {
		this.refillConvertedAmt = refillConvertedAmt;
	}

	public String getRefillDivisionAmt() {
		return this.refillDivisionAmt;
	}

	public void setRefillDivisionAmt(String refillDivisionAmt) {
		this.refillDivisionAmt = refillDivisionAmt;
	}

	public String getRefillProfileId() {
		return this.refillProfileId;
	}

	public void setRefillProfileId(String refillProfileId) {
		this.refillProfileId = refillProfileId;
	}

	public String getRefillPromoDivisionAmt() {
		return this.refillPromoDivisionAmt;
	}

	public void setRefillPromoDivisionAmt(String refillPromoDivisionAmt) {
		this.refillPromoDivisionAmt = refillPromoDivisionAmt;
	}

	public String getRefillTypeCd() {
		return this.refillTypeCd;
	}

	public void setRefillTypeCd(String refillTypeCd) {
		this.refillTypeCd = refillTypeCd;
	}

	public String getRequestedRefillTypeCd() {
		return this.requestedRefillTypeCd;
	}

	public void setRequestedRefillTypeCd(String requestedRefillTypeCd) {
		this.requestedRefillTypeCd = requestedRefillTypeCd;
	}

	public String getSegmentationId() {
		return this.segmentationId;
	}

	public void setSegmentationId(String segmentationId) {
		this.segmentationId = segmentationId;
	}

	public String getServiceClassId() {
		return this.serviceClassId;
	}

	public void setServiceClassId(String serviceClassId) {
		this.serviceClassId = serviceClassId;
	}

	public String getServiceFeeDaysPromoPart() {
		return this.serviceFeeDaysPromoPart;
	}

	public void setServiceFeeDaysPromoPart(String serviceFeeDaysPromoPart) {
		this.serviceFeeDaysPromoPart = serviceFeeDaysPromoPart;
	}

	public String getServiceFeeDaysSurplus() {
		return this.serviceFeeDaysSurplus;
	}

	public void setServiceFeeDaysSurplus(String serviceFeeDaysSurplus) {
		this.serviceFeeDaysSurplus = serviceFeeDaysSurplus;
	}

	public String getSt1SelectionTreeId() {
		return this.st1SelectionTreeId;
	}

	public void setSt1SelectionTreeId(String st1SelectionTreeId) {
		this.st1SelectionTreeId = st1SelectionTreeId;
	}

	public String getSt1SelectionTreeVersionNm() {
		return this.st1SelectionTreeVersionNm;
	}

	public void setSt1SelectionTreeVersionNm(String st1SelectionTreeVersionNm) {
		this.st1SelectionTreeVersionNm = st1SelectionTreeVersionNm;
	}

	public String getSt2SelectionTreeId() {
		return this.st2SelectionTreeId;
	}

	public void setSt2SelectionTreeId(String st2SelectionTreeId) {
		this.st2SelectionTreeId = st2SelectionTreeId;
	}

	public String getSt2SelectionTreeVersionNm() {
		return this.st2SelectionTreeVersionNm;
	}

	public void setSt2SelectionTreeVersionNm(String st2SelectionTreeVersionNm) {
		this.st2SelectionTreeVersionNm = st2SelectionTreeVersionNm;
	}

	public String getSt3SelectionTreeId() {
		return this.st3SelectionTreeId;
	}

	public void setSt3SelectionTreeId(String st3SelectionTreeId) {
		this.st3SelectionTreeId = st3SelectionTreeId;
	}

	public String getSt3SelectionTreeVersionNm() {
		return this.st3SelectionTreeVersionNm;
	}

	public void setSt3SelectionTreeVersionNm(String st3SelectionTreeVersionNm) {
		this.st3SelectionTreeVersionNm = st3SelectionTreeVersionNm;
	}

	public String getSt4SelectionTreeId() {
		return this.st4SelectionTreeId;
	}

	public void setSt4SelectionTreeId(String st4SelectionTreeId) {
		this.st4SelectionTreeId = st4SelectionTreeId;
	}

	public String getSt4SelectionTreeVersionNm() {
		return this.st4SelectionTreeVersionNm;
	}

	public void setSt4SelectionTreeVersionNm(String st4SelectionTreeVersionNm) {
		this.st4SelectionTreeVersionNm = st4SelectionTreeVersionNm;
	}

	public String getSt5SelectionTreeId() {
		return this.st5SelectionTreeId;
	}

	public void setSt5SelectionTreeId(String st5SelectionTreeId) {
		this.st5SelectionTreeId = st5SelectionTreeId;
	}

	public String getSt5SelectionTreeVersionNm() {
		return this.st5SelectionTreeVersionNm;
	}

	public void setSt5SelectionTreeVersionNm(String st5SelectionTreeVersionNm) {
		this.st5SelectionTreeVersionNm = st5SelectionTreeVersionNm;
	}

	public String getSubscriberNr() {
		return this.subscriberNr;
	}

	public void setSubscriberNr(String subscriberNr) {
		this.subscriberNr = subscriberNr;
	}

	public String getSubscriberRegionCd() {
		return this.subscriberRegionCd;
	}

	public void setSubscriberRegionCd(String subscriberRegionCd) {
		this.subscriberRegionCd = subscriberRegionCd;
	}

	public String getSupervisionDaysPromoPart() {
		return this.supervisionDaysPromoPart;
	}

	public void setSupervisionDaysPromoPart(String supervisionDaysPromoPart) {
		this.supervisionDaysPromoPart = supervisionDaysPromoPart;
	}

	public String getSupervisionDaysSurplus() {
		return this.supervisionDaysSurplus;
	}

	public void setSupervisionDaysSurplus(String supervisionDaysSurplus) {
		this.supervisionDaysSurplus = supervisionDaysSurplus;
	}

	public String getTransactionAmt() {
		return this.transactionAmt;
	}

	public void setTransactionAmt(String transactionAmt) {
		this.transactionAmt = transactionAmt;
	}

	public String getTransactionCd() {
		return this.transactionCd;
	}

	public void setTransactionCd(String transactionCd) {
		this.transactionCd = transactionCd;
	}

	public String getTransactionCurrencyCd() {
		return this.transactionCurrencyCd;
	}

	public void setTransactionCurrencyCd(String transactionCurrencyCd) {
		this.transactionCurrencyCd = transactionCurrencyCd;
	}

	public String getTransactionTypeCd() {
		return this.transactionTypeCd;
	}

	public void setTransactionTypeCd(String transactionTypeCd) {
		this.transactionTypeCd = transactionTypeCd;
	}

	public String getVoucherActivationCd() {
		return this.voucherActivationCd;
	}

	public void setVoucherActivationCd(String voucherActivationCd) {
		this.voucherActivationCd = voucherActivationCd;
	}

	public String getVoucherAgentCd() {
		return this.voucherAgentCd;
	}

	public void setVoucherAgentCd(String voucherAgentCd) {
		this.voucherAgentCd = voucherAgentCd;
	}

	public String getVoucherBasedRefillInd() {
		return this.voucherBasedRefillInd;
	}

	public void setVoucherBasedRefillInd(String voucherBasedRefillInd) {
		this.voucherBasedRefillInd = voucherBasedRefillInd;
	}

	public String getVoucherGroupId() {
		return this.voucherGroupId;
	}

	public void setVoucherGroupId(String voucherGroupId) {
		this.voucherGroupId = voucherGroupId;
	}

	public String getVoucherRegionCd() {
		return this.voucherRegionCd;
	}

	public void setVoucherRegionCd(String voucherRegionCd) {
		this.voucherRegionCd = voucherRegionCd;
	}

	public String getVoucherSerialNr() {
		return this.voucherSerialNr;
	}

	public void setVoucherSerialNr(String voucherSerialNr) {
		this.voucherSerialNr = voucherSerialNr;
	}

	public String getWelcomeStatusInd() {
		return this.welcomeStatusInd;
	}

	public void setWelcomeStatusInd(String welcomeStatusInd) {
		this.welcomeStatusInd = welcomeStatusInd;
	}

}