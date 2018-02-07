package nl.youwe.diff.controller;

/*
 * This file is part of the rest diff project.
 *
 * (c) Osman Üngür <osmanungur@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import nl.youwe.diff.dto.DiffRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import name.fraser.neil.plaintext.diff_match_patch;
import javax.validation.Valid;
import java.util.LinkedList;

@RestController
public class DiffController {

    @PostMapping("/diff")
    public LinkedList<diff_match_patch.Diff> diffAction(@RequestBody @Valid DiffRequest diffRequest) {
        diff_match_patch diffMatchPatch = new diff_match_patch();
        diffMatchPatch.Diff_Timeout = diffRequest.getTimeout();

        LinkedList<diff_match_patch.Diff> diffLinkedList = diffMatchPatch.diff_main(diffRequest.getOriginal(), diffRequest.getRevised(), diffRequest.isCheckLines());

        if (diffRequest.getCleanupSemantic()) {
            diffMatchPatch.diff_cleanupSemantic(diffLinkedList);
        }

        if (diffRequest.getCleanupSemanticLossless()) {
            diffMatchPatch.diff_cleanupSemanticLossless(diffLinkedList);
        }

        return diffLinkedList;
    }

}
