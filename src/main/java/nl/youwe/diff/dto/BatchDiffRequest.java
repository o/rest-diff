package nl.youwe.diff.dto;

/*
 * This file is part of the rest diff project.
 *
 * (c) Osman Üngür <osmanungur@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class BatchDiffRequest {

    @NotNull
    @Valid
    private List<BatchContext> context;

    @NotNull
    private Options options;

    public BatchDiffRequest() {
    }

    public List<BatchContext> getContext() {
        return context;
    }

    public Options getOptions() {
        return options;
    }
}
