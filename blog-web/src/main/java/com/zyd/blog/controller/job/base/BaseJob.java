package com.zyd.blog.controller.job.base;

import org.quartz.*;

/**
 * <p>
 * Job 基类，主要是在 {@link Job} 上再封装一层，只让我们自己项目里的Job去实现
 * </p>
 *
 * @package: com.xkcoding.task.quartz.job.base
 * @description: Job 基类，主要是在 {@link Job} 上再封装一层，只让我们自己项目里的Job去实现
 * @author: yangkai.shen
 * @date: Created in 2018-11-26 13:27
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
public interface BaseJob extends Job {
    /**
     * <p>
     * Called by the <code>{@link Scheduler}</code> when a <code>{@link Trigger}</code>
     * fires that is associated with the <code>Job</code>.
     * </p>
     *
     * <p>
     * The implementation may wish to set a
     * {@link JobExecutionContext#setResult(Object) result} object on the
     * {@link JobExecutionContext} before this method exits.  The result itself
     * is meaningless to Quartz, but may be informative to
     * <code>{@link JobListener}s</code> or
     * <code>{@link TriggerListener}s</code> that are watching the job's
     * execution.
     * </p>
     *
     * @param context 上下文
     * @throws JobExecutionException if there is an exception while executing the job.
     */
    @Override
    void execute(JobExecutionContext context) throws JobExecutionException;
}
