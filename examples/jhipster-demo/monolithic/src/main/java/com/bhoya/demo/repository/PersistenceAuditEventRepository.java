package com.bhoya.demo.repository;

import com.bhoya.demo.domain.PersistentAuditEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.Instant;
import java.util.List;

/**
 * Spring Data Couchbase repository for the PersistentAuditEvent entity.
 */
public interface PersistenceAuditEventRepository extends N1qlCouchbaseRepository<PersistentAuditEvent, String> {

    List<PersistentAuditEvent> findByPrincipal(String principal);

    List<PersistentAuditEvent> findByAuditEventDateAfter(Instant after);

    List<PersistentAuditEvent> findByPrincipalAndAuditEventDateAfter(String principal, Instant after);

    List<PersistentAuditEvent> findByPrincipalAndAuditEventDateAfterAndAuditEventType(String principal, Instant after, String type);

    Page<PersistentAuditEvent> findAllByAuditEventDateBetween(Instant fromDate, Instant toDate, Pageable pageable);
}
