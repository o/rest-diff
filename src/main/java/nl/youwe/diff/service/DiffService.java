package nl.youwe.diff.service;

/*
 * This file is part of the rest diff project.
 *
 * (c) Osman Üngür <osmanungur@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import name.fraser.neil.plaintext.diff_match_patch;
import nl.youwe.diff.dto.Context;
import nl.youwe.diff.dto.Options;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class DiffService {

    public LinkedList<diff_match_patch.Diff> getDiff(Context context, Options options) {
        diff_match_patch diffMatchPatch = new diff_match_patch();

        diffMatchPatch.Diff_Timeout = options.getTimeout();

        LinkedList<diff_match_patch.Diff> diffLinkedList = diffMatchPatch.diff_main(context.getOriginal(), context.getRevised(), options.isCheckLines());

        if (options.getCleanupSemantic()) {
            diffMatchPatch.diff_cleanupSemantic(diffLinkedList);
        }

        return diffLinkedList;
    }
    public String toPrettyHtml(LinkedList<diff_match_patch.Diff> diffs) {
        StringBuffer buffer = new StringBuffer();
        diffs.forEach(diff -> {
            switch (diff.operation) {
                case EQUAL:
                    buffer.append(String.format("<span>%s</span>", diff.text));
                    break;
                case INSERT:
                    buffer.append(String.format("<ins>%s</ins>", diff.text));
                    break;
                case  DELETE:
                    buffer.append(String.format("<del>%s</del>", diff.text));
                    break;
            }
        });

        return buffer.toString();
    }

}
