package newlangservice.jobdemonstration.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class StartJobHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public StartJobHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Job job = new Job("About to say hello") {
			protected IStatus run(IProgressMonitor monitor) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
				}
				MessageDialog.openInformation(null, "Hello", "World");
				return Status.OK_STATUS;
			}
		};
		job.schedule();
		return null;
	}
}
