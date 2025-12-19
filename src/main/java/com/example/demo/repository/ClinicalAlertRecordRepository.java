public interface ClinicalAlertRecordRepository extends JpaRepository<ClinicalAlertRecord, Long> {
    List<ClinicalAlertRecord> findByPatientId(Long patientId);
}
