package gr.com.eurotrade.service;

import java.util.List;

import gr.com.eurotrade.entity.Branch;
import gr.com.eurotrade.repository.BranchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService {

	@Autowired
	private BranchRepository branchRepository;
	
	public List<Branch> findAll() {
		return branchRepository.findAll();
	}

	public Branch findById(Integer id) {
		return branchRepository.findById(id);
	}

	
}
