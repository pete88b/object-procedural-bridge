PROMPT ___ Start of load permissions.sql ___
PROMPT

BEGIN
  DELETE FROM permission_sets_data;
  DELETE FROM permissions_data;

  COMMIT;

  permission.create_permission('/manageDiscrepancies', 'The Manage Discrepancies Page', 2);
  permission.create_permission('/selectPagForManual', 'select page for a manual discrepancy', 2);
  permission.create_permission('/selectPidForManual', 'select patient ID for a manual discrepancy', 2);
  permission.create_permission('/selectPrbmsgForManual', 'select description for a manual discrepancy', 2);
  permission.create_permission('/managePatients', 'The Manage Patients Page', 2);
  permission.create_permission('/manageTargets', 'The Manage Targets Page', 2);
  permission.create_permission('/quickAction', 'The Quick Action Page', 2);
  permission.create_permission('/veAction', 'The VE Action Page', 2);
  permission.create_permission('/receiveQueries', 'The Receive Queries Page', 2);
  permission.create_permission('/welcome', 'The Welcome Page', 2);
  permission.create_permission('/loggingConfig', 'The Logging Configuration Page', 2);
  permission.create_permission('/dbLoggingAdmin', 'The Database Logging Admin Page', 2);
  permission.create_permission('/managePermissionSets', 'The Manage Permission Sets Page', 2);
  permission.create_permission('/managePermissions', 'The Manage Permissions Page', 2);
  permission.create_permission('/manageProperties', 'The Manage Properties Page', 2);
  permission.create_permission('/manageValueGroups', 'The Manage Value Groups Page', 2);
  permission.create_permission('/messageAdmin', 'The Message Admin Page', 2);
  permission.create_permission('/timingAdmin', 'The Timing Admin Page', 2);

  permission.create_permission('ADMIN', 'DVM Administrator', 1);
  permission.create_permission('CDM', 'Clinical Data Manager', 1);
  permission.create_permission('DBM', 'Database Manager', 1);

  permission.create_permission('DISCREPANCY MANAGER', 'Discrepancy Manager', 1);
  permission.create_permission('PATIENT MANAGER', 'Patient Manager', 1);
  permission.create_permission('QUERY RECEIVER', 'Query Receiver', 1);
  permission.create_permission('TARGET MANAGER', 'Target Manager', 1);

  permission.create_permission('discrepancy.add_manual', '', 2);
  permission.create_permission('discrepancy.receive', '', 2);
  permission.create_permission('discrepancy.save_changes', '', 2);
  permission.create_permission('discrepancy.action_reviewed', '', 2);
  permission.create_permission('discrepancys.get_receivable', '', 2);
  permission.create_permission('discrepancys.get_discrepancy_nums', '', 2);
  permission.create_permission('discrepancys.get_discrepancy', '', 2);
  permission.create_permission('discrepancys.get_manual_dscs', '', 2);
  permission.create_permission('discrepancys.retire', '', 2);
  permission.create_permission('discrepancys.quick_action', '', 2);
  permission.create_permission('discrepancys.ve_action', '', 2);

  permission.create_permission('dscs.get_dscs_for_quick', '', 2);
  permission.create_permission('dscs.get_dscnums_for_quick', '', 2);
  
  permission.create_permission('patient.del', '', 2);
  permission.create_permission('patient.ins', '', 2);
  permission.create_permission('patient.upd', '', 2);
  permission.create_permission('patients.get_patients', '', 2);
  permission.create_permission('patients.get_sites', '', 2);
  permission.create_permission('patients.update_site_info', '', 2);

  permission.create_permission('pags.get_pags_for_manual', '', 2);

  permission.create_permission('pids.get_pids', '', 2);
  permission.create_permission('pids.get_pids_for_manual', '', 2);

  permission.create_permission('prbcods.get_filtered', '', 2);
  permission.create_permission('prbcods.get_prbcods_for_ve', '', 2);
  
  permission.create_permission('prbmsgs.get_prbmsgs_for_manual', '', 2);

  permission.create_permission('target.del', '', 2);
  permission.create_permission('target.ins', '', 2);
  permission.create_permission('target.upd', '', 2);
  permission.create_permission('targets.get_filtered', '', 2);

  permission.allow('ADMIN', '/dbLoggingAdmin');
  permission.allow('ADMIN', '/loggingConfig');
  permission.allow('ADMIN', '/managePermissionSets');
  permission.allow('ADMIN', '/managePermissions');
  permission.allow('ADMIN', '/manageProperties');
  permission.allow('ADMIN', '/manageValueGroups');
  permission.allow('ADMIN', '/messageAdmin');
  permission.allow('ADMIN', '/timingAdmin');

  permission.allow('DBM', 'DISCREPANCY MANAGER');
  permission.allow('DBM', 'PATIENT MANAGER');
  permission.allow('DBM', 'QUERY RECEIVER');
  permission.allow('DBM', 'TARGET MANAGER');

  permission.allow('DISCREPANCY MANAGER', '/manageDiscrepancies');
  permission.allow('DISCREPANCY MANAGER', '/selectPagForManual');
  permission.allow('DISCREPANCY MANAGER', '/selectPidForManual');
  permission.allow('DISCREPANCY MANAGER', '/selectPrbmsgForManual');
  permission.allow('DISCREPANCY MANAGER', '/quickAction');
  permission.allow('DISCREPANCY MANAGER', '/veAction');
  permission.allow('DISCREPANCY MANAGER', 'discrepancy.add_manual');
  permission.allow('DISCREPANCY MANAGER', 'discrepancy.save_changes');
  permission.allow('DISCREPANCY MANAGER', 'discrepancy.action_reviewed');
  
  permission.allow('DISCREPANCY MANAGER', 'discrepancys.get_discrepancy_nums');
  permission.allow('DISCREPANCY MANAGER', 'discrepancys.get_discrepancy');
  permission.allow('DISCREPANCY MANAGER', 'discrepancys.get_manual_dscs');
  permission.allow('DISCREPANCY MANAGER', 'discrepancys.retire');
  permission.allow('DISCREPANCY MANAGER', 'discrepancys.quick_action');
  permission.allow('DISCREPANCY MANAGER', 'discrepancys.ve_action');
  permission.allow('DISCREPANCY MANAGER', 'dscs.get_dscs_for_quick');
  permission.allow('DISCREPANCY MANAGER', 'dscs.get_dscnums_for_quick');
  permission.allow('DISCREPANCY MANAGER', 'pags.get_pags_for_manual');
  permission.allow('DISCREPANCY MANAGER', 'pids.get_pids');
  permission.allow('DISCREPANCY MANAGER', 'pids.get_pids_for_manual');
  permission.allow('DISCREPANCY MANAGER', 'prbcods.get_filtered');
  permission.allow('DISCREPANCY MANAGER', 'prbcods.get_prbcods_for_ve');
  permission.allow('DISCREPANCY MANAGER', 'prbmsgs.get_prbmsgs_for_manual');
  
  permission.allow('PATIENT MANAGER', '/managePatients');
  permission.allow('PATIENT MANAGER', 'patient.del');
  permission.allow('PATIENT MANAGER', 'patient.ins');
  permission.allow('PATIENT MANAGER', 'patient.upd');
  permission.allow('PATIENT MANAGER', 'patients.get_patients');
  permission.allow('PATIENT MANAGER', 'patients.get_sites');
  permission.allow('PATIENT MANAGER', 'patients.update_site_info');

  permission.allow('QUERY RECEIVER', '/receiveQueries');
  permission.allow('QUERY RECEIVER', 'discrepancy.receive');
  permission.allow('QUERY RECEIVER', 'discrepancys.get_receivable');

  permission.allow('TARGET MANAGER', '/manageTargets');
  permission.allow('TARGET MANAGER', 'target.del');
  permission.allow('TARGET MANAGER', 'target.ins');
  permission.allow('TARGET MANAGER', 'target.upd');
  permission.allow('TARGET MANAGER', 'targets.get_filtered');

END;
/

PROMPT ___ End of load permissions.sql ___
