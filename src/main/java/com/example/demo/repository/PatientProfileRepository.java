public interface PatientProfileRepository extends JpaRepository<PatientProfile, Long> {
    Optional<PatientProfile> findByEmail(String email);
    Optional<PatientProfile> findByPatientId(String patientId);
}
