package br.ucsal.dto.requests;

import java.sql.Timestamp;
public record ApprovalRequest(Long userId, boolean isApproved) {
}