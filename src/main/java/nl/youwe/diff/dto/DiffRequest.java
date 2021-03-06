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

public class DiffRequest {

    @NotNull
    @Valid
    private Context context;

    @NotNull
    private Options options;

    public DiffRequest() {
    }

    public Context getContext() {
        return context;
    }

    public Options getOptions() {
        return options;
    }
}
