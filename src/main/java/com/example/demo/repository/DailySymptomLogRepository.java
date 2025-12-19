public interface DailySymptomLogRepository extends JpaRepository<DailySymptomLog, Long> {
    List<DailySymptomLog> findByPatientId(Long patientId);
}
