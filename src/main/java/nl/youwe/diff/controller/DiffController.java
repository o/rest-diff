package nl.youwe.diff.controller;

/*
 * This file is part of the rest diff project.
 *
 * (c) Osman Üngür <osmanungur@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import name.fraser.neil.plaintext.diff_match_patch;
import nl.youwe.diff.dto.BatchDiffRequest;
import nl.youwe.diff.dto.BatchDiffResponse;
import nl.youwe.diff.dto.DiffRequest;
import nl.youwe.diff.service.DiffService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DiffController {

    private final DiffService diffService;

    private final Logger logger;

    @Autowired
    public DiffController(DiffService diffService, Logger logger) {
        this.diffService = diffService;
        this.logger = logger;
    }


    @PostMapping("/diff")
    public LinkedList<diff_match_patch.Diff> diffAction(@RequestBody @Valid DiffRequest diffRequest) {
        return diffService.getDiff(diffRequest.getContext(), diffRequest.getOptions());
    }

    @PostMapping("/diff/html")
    public String htmlDiffAction(@RequestBody @Valid DiffRequest diffRequest) {
        return diffService.toPrettyHtml(
                diffService.getDiff(diffRequest.getContext(), diffRequest.getOptions())
        );
    }

    @PostMapping("/diff/batch")
    public List<BatchDiffResponse> batchDiffAction(@RequestBody @Valid BatchDiffRequest batchDiffRequest) {
        return batchDiffRequest.getContext()
                .stream()
                .map(batchContext -> new BatchDiffResponse(batchContext.getIdentifier(), diffService.getDiff(batchContext, batchDiffRequest.getOptions())))
                .collect(Collectors.toList());
    }

}
